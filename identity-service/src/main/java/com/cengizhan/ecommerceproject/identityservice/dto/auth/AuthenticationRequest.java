package com.cengizhan.ecommerceproject.identityservice.dto.auth;

public record AuthenticationRequest(
        String email,
        String password
) {
}
