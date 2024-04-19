package com.cengizhan.ecommerceproject.productservice.repository;

import com.cengizhan.ecommerceproject.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);

    List<Product> findByRelationProductCategoryId(Long productCategoryId);
}
