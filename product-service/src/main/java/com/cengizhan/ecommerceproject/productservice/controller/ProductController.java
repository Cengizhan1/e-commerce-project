package com.cengizhan.ecommerceproject.productservice.controller;


import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.service.ProductService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/v1/api/product")
public class ProductController{

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping(value = "/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> listByCategory(@PathVariable(name = "categoryId") Long categoryId) {
        return ResponseEntity.ok(service.listByCategory(categoryId));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/{id}/add-basket/quantity/{quantity}")
    public ResponseEntity<Void> addBasket(@NotBlank @PathVariable(name = "id") Long id,
                                          @NotBlank @PathVariable(name = "quantity") int quantity) {
        service.addBasket(id,quantity);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}/remove-basket")
    public ResponseEntity<Void> removeBasket(@NotBlank @PathVariable(name = "id") Long id) {
        service.removeBasket(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/clear-basket")
    public ResponseEntity<Void> clearBasket(){
        service.clearBasket();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/get-basket")
    public ResponseEntity<List<ProductDto>> getBasket(){
        return ResponseEntity.ok(service.getBasket());
    }
}
