package com.cengizhan.ecommerceproject.productservice.repository;

import com.cengizhan.ecommerceproject.productservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByRelationProductId(Long productId);

}
