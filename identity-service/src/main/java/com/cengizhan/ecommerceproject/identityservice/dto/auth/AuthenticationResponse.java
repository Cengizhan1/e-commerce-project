package com.cengizhan.ecommerceproject.identityservice.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthenticationResponse(
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("refresh_token")
        String refreshToken,
        @JsonProperty("firstname")
        String firstname
) {
        public static AuthenticationResponse build(String accessToken, String refreshToken, String firstname) {
                return new AuthenticationResponse(accessToken, refreshToken, firstname);
        }
}
