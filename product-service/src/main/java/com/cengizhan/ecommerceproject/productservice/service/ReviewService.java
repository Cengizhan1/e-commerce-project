package com.cengizhan.ecommerceproject.productservice.service;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.dto.ReviewDto;
import com.cengizhan.ecommerceproject.productservice.entity.Review;
import com.cengizhan.ecommerceproject.productservice.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.repository.IReviewRepository;
import com.cengizhan.ecommerceproject.productservice.exception.ReviewNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ReviewService{

    private final IReviewRepository iReviewRepository;
    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    
    public ReviewDto entityToDto(Review review) {
        return modelMapperBean.modelMapperMethod().map(review,ReviewDto.class);
    }

    
    public Review dtoToEntity(ReviewDto reviewDto) {
        return  modelMapperBean.modelMapperMethod().map(reviewDto, Review.class);
    }

    // CREATE
    @Transactional
    public ReviewDto reviewCreate(ReviewDto reviewDto) {
        if (reviewDto != null) {
            Review review = dtoToEntity(reviewDto);
            review.setRelationProduct(iProductRepository.findById(reviewDto.getProductId()).get());
            review.setUserId(1);
            iReviewRepository.save(review);
            reviewDto.setId(review.getId());
        } else {
            throw new NullPointerException("reviewDto null veri");
        }
        return reviewDto;
    }

    // LIST
    public List<ReviewDto> reviewListByProductId(Long productId) {
        List<Review> entityList = iReviewRepository.findByRelationProductId(productId);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review entity : entityList) {
            ReviewDto reviewDto = entityToDto(entity);
            reviewDtoList.add(reviewDto);
        }
        log.info("Liste Sayısı: " + reviewDtoList.size());
        return reviewDtoList;
    }

    // FIND
    public ReviewDto reviewServiceFindById(Long id) {
        Review findReview = iReviewRepository.findById(id)
                    .orElseThrow(() -> new ReviewNotFoundException(id + " nolu id yoktur"));
        return entityToDto(findReview);
    }

    // UPDATE
    @Transactional // create, delete, update
    public ReviewDto reviewServiceUpdate(Long id, ReviewDto reviewDto) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        ReviewDto reviewFindDto = reviewServiceFindById(id);
        if (reviewFindDto != null) {
            Review review = dtoToEntity(reviewFindDto);
            review.setReview(reviewDto.getReview());
            review.setUserId(1);
            review.setRating(reviewDto.getRating());
            review.setRelationProduct(iProductRepository.findById(reviewDto.getProductId()).get());
            iReviewRepository.save(review);
        }
        return reviewDto;
    }

    // DELETE
    @Transactional // create, delete, update
    public ReviewDto reviewServiceDeleteById(Long id) {
        ReviewDto reviewFindDto = reviewServiceFindById(id);
        if (reviewFindDto != null) {
            iReviewRepository.deleteById(id);
        }
        return reviewFindDto;
    }
}
