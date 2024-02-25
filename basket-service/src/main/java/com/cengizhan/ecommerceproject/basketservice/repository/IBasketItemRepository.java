package com.cengizhan.ecommerceproject.basketservice.repository;

import com.cengizhan.ecommerceproject.basketservice.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IBasketItemRepository extends JpaRepository<BasketItem, Long> {
    Optional<BasketItem> findFirstByProductIdAndRelationBasketId(Long productId, Long basketId);
    void deleteAllByRelationBasketId(Long basketId);
    List<BasketItem> findAllByRelationBasketId(Long basketId);
}
