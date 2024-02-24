package com.cengizhan.ecommerceproject.basketservice.repository;

import com.cengizhan.ecommerceproject.basketservice.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IBasketRepository extends JpaRepository<Basket, Long> {
    Optional<Basket> findByUserId(Integer userId);
    Boolean existsByUserId(Integer userId);
}
