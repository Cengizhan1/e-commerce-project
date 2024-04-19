package com.cengizhan.ecommerceproject.identityservice.service;

import com.cengizhan.ecommerceproject.identityservice.controller.AuthenticationController;
import com.cengizhan.ecommerceproject.identityservice.dto.auth.AuthenticationRequest;
import com.cengizhan.ecommerceproject.identityservice.dto.auth.AuthenticationResponse;
import com.cengizhan.ecommerceproject.identityservice.dto.auth.RegisterRequest;
import com.cengizhan.ecommerceproject.identityservice.clients.BasketClient;
import com.cengizhan.ecommerceproject.identityservice.config.JwtService;
import com.cengizhan.ecommerceproject.identityservice.entity.Token;
import com.cengizhan.ecommerceproject.identityservice.entity.User;
import com.cengizhan.ecommerceproject.identityservice.repository.TokenRepository;
import com.cengizhan.ecommerceproject.identityservice.repository.IUserRepository;
import com.cengizhan.ecommerceproject.identityservice.entity.enums.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService extends BaseService {
    private final IUserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BasketClient basketClient;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        basketClient.createBasket(savedUser.getId());
        return AuthenticationResponse.build(jwtToken, refreshToken, request.firstname());
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = repository.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.build(
                jwtToken,
                refreshToken,
                user.getFirstname()
        );
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.build(
                        accessToken,
                        refreshToken,
                        userEmail
                );
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    public Integer validateToken(String token) {
        try {
            return jwtService.validateToken(token);
        } catch (Exception e) {
            logger.error("validateToken method threw an exception", e);
            throw e;
        }
    }
}
