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
    public ResponseEntity<?> reviewCreate(@Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(service.reviewCreate(reviewDto));
    }

    // FIND
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> reviewServiceFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.reviewServiceFindById(id));
    }

    // LIST
    // /review/api/v1/list
    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<List<ReviewDto>> reviewListByProductId(@PathVariable(name = "productId") Long categoryId) {
        return ResponseEntity.ok(service.reviewListByProductId(categoryId));
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> reviewUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.status(200).body(service.reviewServiceUpdate(id, reviewDto));
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> reviewDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(service.reviewServiceDeleteById(id));
    }
}
