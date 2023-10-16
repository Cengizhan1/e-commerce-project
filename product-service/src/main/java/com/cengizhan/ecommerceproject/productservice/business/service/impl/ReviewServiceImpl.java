package com.cengizhan.ecommerceproject.productservice.business.service.impl;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.dto.ReviewDto;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductService;
import com.cengizhan.ecommerceproject.productservice.business.service.IReviewService;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ReviewEntity;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.data.repository.IReviewRepository;
import com.cengizhan.ecommerceproject.productservice.exception.CustomException;
import com.cengizhan.ecommerceproject.productservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ReviewServiceImpl implements IReviewService<ReviewDto, ReviewEntity> {

    private final IReviewRepository iReviewRepository;
    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public ReviewDto entityToDto(ReviewEntity reviewEntity) {
        return modelMapperBean.modelMapperMethod().map(reviewEntity,ReviewDto.class);
    }

    @Override
    public ReviewEntity dtoToEntity(ReviewDto reviewDto) {
        return  modelMapperBean.modelMapperMethod().map(reviewDto,ReviewEntity.class);
    }

    // CREATE
    @Override
    @Transactional // create, delete, update
    public ReviewDto reviewServiceCreate(ReviewDto reviewDto) {
        if (reviewDto != null) {
            ReviewEntity reviewEntity = dtoToEntity(reviewDto);
            reviewEntity.setRelationProductEntity(iProductRepository.findById(reviewDto.getProductId()).get());
            iReviewRepository.save(reviewEntity);
            reviewDto.setId(reviewEntity.getId());
        } else {
            throw new NullPointerException("reviewDto null veri");
        }
        return reviewDto;
    }

    // LIST
    @Override
    public List<ReviewDto> reviewServiceListByProductId(Long productId) {
        List<ReviewEntity> entityList = iReviewRepository.findByRelationProductEntityId(productId);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (ReviewEntity entity : entityList) {
            ReviewDto reviewDto = entityToDto(entity);
            reviewDtoList.add(reviewDto);
        }
        log.info("Liste Sayısı: " + reviewDtoList.size());
        return reviewDtoList;
    }

    @Override
    public ReviewDto reviewServiceFindById(Long id) {
        ReviewEntity findReviewEntity = null;
        if (id != null) {
            findReviewEntity = iReviewRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findReviewEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public ReviewDto reviewServiceUpdate(Long id, ReviewDto reviewDto) {
        ReviewDto reviewFindDto = reviewServiceFindById(id);
        if (reviewFindDto != null) {
            ReviewEntity reviewEntity = dtoToEntity(reviewFindDto);
            reviewEntity.setReview(reviewDto.getReview());
            reviewEntity.setRating(reviewDto.getRating());
            reviewEntity.setRelationProductEntity(iProductRepository.findById(reviewDto.getProductId()).get());
            iReviewRepository.save(reviewEntity);
        }
        return reviewDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public ReviewDto reviewServiceDeleteById(Long id) {
        ReviewDto reviewFindDto = reviewServiceFindById(id);
        if (reviewFindDto != null) {
            iReviewRepository.deleteById(id);
        }
        return reviewFindDto;
    }
}
