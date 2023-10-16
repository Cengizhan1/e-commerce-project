package com.cengizhan.ecommerceproject.productservice.data.repository;

import com.cengizhan.ecommerceproject.productservice.data.entity.ProductCategoryEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductCategoryRepository extends CrudRepository<ProductCategoryEntity,Long> {
    Optional<ProductCategoryEntity> findByName(String name);
}
