package com.cengizhan.ecommerceproject.productservice.client;

import com.cengizhan.ecommerceproject.productservice.business.dto.BasketItemDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "basket-service", url = "http://localhost:8765/v1/api/basket")
public interface BasketClient{

    @PostMapping("/add/{userId}")
    ResponseEntity<Void> addProductToBasket(@PathVariable("userId") Integer userId,
                                            @RequestBody BasketItemDto basketItemDto,
                                            @RequestHeader("Authorization") String authorizationHeader);

    @PostMapping("/remove/{userId}/{productId}")
    ResponseEntity<Void> removeProductFromBasket(@PathVariable("userId") Integer userId,
                                                 @PathVariable("productId") Long productId,
                                                 @RequestHeader("Authorization") String authorizationHeader);

    @PostMapping("/remove/{userId}")
    ResponseEntity<Void> clearBasket(@PathVariable("userId") Integer userId,
                                     @RequestHeader("Authorization") String authorizationHeader);

    @GetMapping("/list/{userId}")
    ResponseEntity<List<BasketItemDto>> listProductsInBasket(@PathVariable("userId") Integer userId,
                                                             @RequestHeader("Authorization") String authorizationHeader);
}