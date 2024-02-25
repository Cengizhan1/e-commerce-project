package com.cengizhan.ecommerceproject.orderservice.repository;

import com.cengizhan.ecommerceproject.orderservice.entity.Order;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.OrderStateEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findFirstByUserIdAndOrderState(Integer userId, OrderStateEnum orderState);
    List<Order> findAllByUserId(Integer userId);
}
