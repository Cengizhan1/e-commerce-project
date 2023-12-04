package com.cengizhan.ecommerceproject.identityservice.controller.impl;

import com.cengizhan.ecommerceproject.identityservice.auth.AuthenticationRequest;
import com.cengizhan.ecommerceproject.identityservice.auth.AuthenticationResponse;
import com.cengizhan.ecommerceproject.identityservice.auth.RegisterRequest;
import com.cengizhan.ecommerceproject.identityservice.business.service.impl.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/identity-service/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final AuthenticationService service;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationApi.class);


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (Exception e) {
            logger.error("register method threw an exception", e);
            throw e;
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (Exception e) {
            logger.error("authenticate method threw an exception", e);
            throw e;
        }
    }


    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @GetMapping("/validate")
    public void validateToken(@RequestParam("token") String token) {
        try {
            service.validateToken(token);
        } catch (Exception e) {
            logger.error("validateToken method threw an exception", e);
            throw e;
        }
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }


}
