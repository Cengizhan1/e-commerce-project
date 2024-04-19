package com.cengizhan.ecommerceproject.identityservice.dto;

import com.cengizhan.ecommerceproject.identityservice.entity.User;

public record UserDto(
        Integer id,
        String firstname,
        String lastname,
        String email
) {
    public static UserDto convert(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }
}
