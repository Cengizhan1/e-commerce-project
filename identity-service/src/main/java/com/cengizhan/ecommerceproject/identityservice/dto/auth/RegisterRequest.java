package com.cengizhan.ecommerceproject.identityservice.dto.auth;

import com.cengizhan.ecommerceproject.identityservice.entity.Role;

public record RegisterRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        Role role
) {}
