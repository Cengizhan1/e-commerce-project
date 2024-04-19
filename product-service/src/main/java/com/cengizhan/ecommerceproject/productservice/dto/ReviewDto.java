package com.cengizhan.ecommerceproject.productservice.dto;

import com.cengizhan.ecommerceproject.productservice.entity.Review;

import java.io.Serial;
import java.io.Serializable;


public record ReviewDto(
         Long id,
         String review,
         Integer rating,
         Long productId
){
        public static ReviewDto convert(Review review){
            return new ReviewDto(
                    review.getId(),
                    review.getReview(),
                    review.getRating(),
                    review.getRelationProduct().getId()
            );
        }
}
