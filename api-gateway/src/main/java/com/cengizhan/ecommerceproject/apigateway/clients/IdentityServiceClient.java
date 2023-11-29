package com.cengizhan.ecommerceproject.apigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "identity-service", url = "http://localhost:8765/api/v1/auth/") // Change the service name accordingly
public interface IdentityServiceClient {
    @GetMapping("validate") // Update the endpoint accordingly
    void validateToken(@RequestParam("token") String token);
}