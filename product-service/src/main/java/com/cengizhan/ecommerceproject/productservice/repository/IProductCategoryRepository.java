package com.cengizhan.ecommerceproject.productservice.repository;

import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
    Optional<ProductCategory> findByName(String name);
}
