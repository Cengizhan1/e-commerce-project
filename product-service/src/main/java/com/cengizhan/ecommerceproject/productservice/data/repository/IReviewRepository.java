package com.cengizhan.ecommerceproject.productservice.data.repository;

import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IReviewRepository extends CrudRepository<ReviewEntity,Long> {
//    Optional<ReviewEntity> findByReview(String name);

    List<ReviewEntity> findByRelationProductEntityId(Long productId);

}
