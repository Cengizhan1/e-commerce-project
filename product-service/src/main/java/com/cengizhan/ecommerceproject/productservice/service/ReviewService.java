package com.cengizhan.ecommerceproject.productservice.service;

import com.cengizhan.ecommerceproject.productservice.dto.ReviewDto;
import com.cengizhan.ecommerceproject.productservice.entity.Review;
import com.cengizhan.ecommerceproject.productservice.repository.ReviewRepository;
import com.cengizhan.ecommerceproject.productservice.exception.ReviewNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    public ReviewService(ReviewRepository reviewRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
    }

    @Transactional
    public ReviewDto create(ReviewDto reviewDto) {
        Review review = new Review();
        review.setReview(reviewDto.review());
        review.setRelationProduct(productService.findProduct(reviewDto.productId()));
        reviewRepository.save(review);
        return ReviewDto.convert(review);
    }

    public List<ReviewDto> listByProductId(Long productId) {
        return reviewRepository.findByRelationProductId(productId).stream().map(ReviewDto::convert).toList();
    }

    public ReviewDto findById(Long id) {
        return ReviewDto.convert(findReview(id));
    }

    @Transactional // create, delete, update
    public ReviewDto update(Long id, ReviewDto reviewDto) {
        Review review = findReview(id);
        review.setReview(reviewDto.review());
        reviewRepository.save(review);
        return ReviewDto.convert(review);
    }

    @Transactional // create, delete, update
    public void deleteById(Long id) {
        reviewRepository.delete(findReview(id));
    }

    private Review findReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found for id: " + id));
    }
}
