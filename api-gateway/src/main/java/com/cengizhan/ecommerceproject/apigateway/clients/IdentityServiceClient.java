package com.cengizhan.ecommerceproject.apigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "identity-service", url = "http://localhost:8765/identity-service/api/v1/auth/")
public interface IdentityServiceClient {
    @GetMapping("validate") // Update the endpoint accordingly
    void validateToken(@RequestParam("token") String token);
}