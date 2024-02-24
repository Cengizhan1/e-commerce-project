package com.cengizhan.ecommerceproject.productservice.controller;

import com.cengizhan.ecommerceproject.productservice.business.dto.ProductCategoryDto;
import com.cengizhan.ecommerceproject.productservice.business.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/v1/api/product-category")
public class ProductCategoryController {
    // injection
    private final ProductCategoryService service;

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> categoryList() {
       return ResponseEntity.ok(service.categoryList());
    }
}
