package com.cengizhan.ecommerceproject.apigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "identity-service", url = "http://localhost:8765/v1/api/user/auth/")
public interface IdentityServiceClient {
    @GetMapping("validate")
    void validateToken(@RequestParam("token") String token);
}