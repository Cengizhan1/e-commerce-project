package com.cengizhan.ecommerceproject.productservice.controller.impl;


import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.dto.ReviewDto;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductService;
import com.cengizhan.ecommerceproject.productservice.business.service.IReviewService;
import com.cengizhan.ecommerceproject.productservice.controller.IProductApi;
import com.cengizhan.ecommerceproject.productservice.controller.IReviewApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

// API
@RestController
//@CrossOrigin(origins = FrontendUrl.REACT_URL)
@RequestMapping("/review/api/v1")
public class ReviewApiImpl implements IReviewApi<ReviewDto> {
    // injection
    private final IReviewService iReviewService;

    // CREATE
    // /review/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> reviewApiCreate(@Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.ok(iReviewService.reviewServiceCreate(reviewDto));
    }

    // LIST
    // /review/api/v1/list
    @Override
    @GetMapping(value = "/list/{categoryId}")
    public ResponseEntity<List<ReviewDto>> reviewApiListByProduct(@PathVariable(name = "categoryId") Long categoryId) {
       return ResponseEntity.ok(iReviewService.reviewServiceListByProductId(categoryId));
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> reviewApiUpdate(@PathVariable(name = "id") Long id,@Valid @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.status(200).body(iReviewService.reviewServiceUpdate(id, reviewDto));
        }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> reviewApiDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iReviewService.reviewServiceDeleteById(id));
    }
}
