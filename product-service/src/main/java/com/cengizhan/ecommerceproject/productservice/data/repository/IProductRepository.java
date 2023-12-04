package com.cengizhan.ecommerceproject.productservice.data.repository;

import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository  extends CrudRepository<ProductEntity,Long> {
    Optional<ProductEntity> findByName(String name);

    List<ProductEntity> findByRelationProductCategoryEntityId(Long productCategoryId);

    List<ProductEntity> findByUserId(Integer userId);

}
