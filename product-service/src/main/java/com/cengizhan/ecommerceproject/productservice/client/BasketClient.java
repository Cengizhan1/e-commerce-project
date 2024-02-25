package com.cengizhan.ecommerceproject.productservice.client;

import com.cengizhan.ecommerceproject.productservice.business.dto.BasketItemDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "basket-service", url = "/v1/api/basket")
public interface BasketClient{

    @PostMapping("/add/{userId}")
    ResponseEntity<Void> addProductToBasket(@PathVariable("userId") Integer userId,
                                            @RequestBody BasketItemDto basketItemDto);

    @PostMapping("/remove/{userId}/{productId}")
    ResponseEntity<Void> removeProductFromBasket(@PathVariable("userId") Integer userId,
                                                 @PathVariable("productId") Long productId);

    @PostMapping("/remove/{userId}")
    ResponseEntity<Void> clearBasket(@PathVariable("userId") Integer userId);

    @GetMapping("/list/{userId}")
    ResponseEntity<List<BasketItemDto>> listProductsInBasket(@PathVariable("userId") Integer userId);
}