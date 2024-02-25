package com.cengizhan.ecommerceproject.orderservice.repository;

import com.cengizhan.ecommerceproject.orderservice.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
}
