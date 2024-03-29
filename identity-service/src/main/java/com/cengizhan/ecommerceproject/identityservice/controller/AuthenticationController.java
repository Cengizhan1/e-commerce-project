package com.cengizhan.ecommerceproject.identityservice.controller;

import com.cengizhan.ecommerceproject.identityservice.dto.auth.AuthenticationRequest;
import com.cengizhan.ecommerceproject.identityservice.dto.auth.AuthenticationResponse;
import com.cengizhan.ecommerceproject.identityservice.dto.auth.RegisterRequest;
import com.cengizhan.ecommerceproject.identityservice.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/api/user/auth")
public class AuthenticationController {

    private final AuthenticationService service;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }


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
    public Integer validateToken(@RequestParam("token") String token) {
        return service.validateToken(token);
    }

    @GetMapping("/get-user-id")
    public ResponseEntity<String> getUserId(@RequestParam("token") String token) {
        return ResponseEntity.ok("1");
    }
}
