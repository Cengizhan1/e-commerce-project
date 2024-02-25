package com.cengizhan.ecommerceproject.basketservice.controller;

import com.cengizhan.ecommerceproject.basketservice.dto.BasketItemDto;
import com.cengizhan.ecommerceproject.basketservice.service.BasketService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/basket")
public class BasketController {

    private final BasketService service;

    public BasketController(BasketService service) {
        this.service = service;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Void> createBasket(@PathVariable("userId") Integer userId) {
        service.basketCreate(userId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/add/{userId}")
    public ResponseEntity<Void> addProductToBasket(@PathVariable("userId") Integer userId, @RequestBody BasketItemDto basketItemDto, HttpServletRequest request) {
        service.addProductToBasket(basketItemDto.productId(), basketItemDto.quantity(), userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/{userId}/{productId}")
    public ResponseEntity<Void> removeProductFromBasket(@PathVariable("userId") Integer userId, @PathVariable("productId") Long productId) {
        service.removeProductFromBasket(userId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove/{userId}")
    public ResponseEntity<Void> clearBasket(@PathVariable("userId") Integer userId) {
        service.clearBasket(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<BasketItemDto>> listProductsInBasket(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(service.listProductsInBasket(userId));
    }


}
