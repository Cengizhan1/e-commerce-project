package com.cengizhan.ecommerceproject.apigateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service")
public interface IdentityServiceClient {

    @GetMapping("product-service/product-category/api/v1/test")
    String validateToken();
}