package com.cengizhan.ecommerceproject.identityservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "basket-service", url = "http://localhost:8765/v1/api/basket")
public interface BasketClient {
    @PostMapping("/create/{userId}")
    ResponseEntity<Void> createBasket(@PathVariable("userId") Integer userId);
}
