package com.cengizhan.ecommerceproject.productservice.data.repository;

import com.cengizhan.ecommerceproject.productservice.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface IProductRepository  extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);

    List<Product> findByRelationProductCategoryId(Long productCategoryId);
}
