package com.cengizhan.ecommerceproject.identityservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "product-service", url = "http://localhost:8765/product-service/product/api/v1/")
public interface ProductServiceClient {

    @GetMapping("/listByUserId/{userId}")
    public List<Product> getProductListByUserId(@PathVariable("userId") Integer userId,
                                                @RequestHeader("Authorization") String authorizationHeader);

    @GetMapping("/find/{id}")
    public Product getProduct(@PathVariable("id") Long id,
                              @RequestHeader("Authorization") String authorizationHeader);

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product,
                                 @RequestHeader("Authorization") String authorizationHeader);

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product, @RequestHeader("Authorization") String authorizationHeader);

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable("id") Long id,
                                           @RequestHeader("Authorization") String authorizationHeader);

}