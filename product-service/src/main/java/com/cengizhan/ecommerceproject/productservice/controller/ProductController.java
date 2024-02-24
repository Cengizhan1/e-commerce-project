package com.cengizhan.ecommerceproject.productservice.controller;


import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.service.ProductService;
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



}
