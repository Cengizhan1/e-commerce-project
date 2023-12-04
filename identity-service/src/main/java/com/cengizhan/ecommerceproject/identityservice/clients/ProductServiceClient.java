package com.cengizhan.ecommerceproject.identityservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "product-service", url = "http://localhost:8765/product-service/product/api/v1/")
public interface ProductServiceClient {

    @GetMapping("/listByUserId/{userId}")
    public  List<Product> getProductListByUserId(@PathVariable("userId") Integer userId,
                                                 @RequestHeader("Authorization") String authorizationHeader);
}