package com.cengizhan.ecommerceproject.productservice.controller;


import com.cengizhan.ecommerceproject.productservice.dto.ReviewDto;
import com.cengizhan.ecommerceproject.productservice.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/v1/api/review")
public class ReviewController {
    // injection
    private final ReviewService service;

    // CREATE
    // /review/api/v1/create
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(service.create(reviewDto));
    }

    // FIND
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // LIST
    // /review/api/v1/list
    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<List<ReviewDto>> listByProductId(@PathVariable(name = "productId") Long productId) {
        return ResponseEntity.ok(service.listByProductId(productId));
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.status(200).body(service.update(id, reviewDto));
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> reviewDeleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
