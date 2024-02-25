package com.cengizhan.ecommerceproject.orderservice.service;

import com.cengizhan.ecommerceproject.orderservice.dto.NewOrderRequest;
import com.cengizhan.ecommerceproject.orderservice.dto.OrderDto;
import com.cengizhan.ecommerceproject.orderservice.entity.Order;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.OrderStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentStateEnum;
import com.cengizhan.ecommerceproject.orderservice.exception.ActiveOrderNotFoundException;
import com.cengizhan.ecommerceproject.orderservice.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final IOrderRepository iOrderRepository;
    private final OrderedProductService orderedProductService;

    public OrderService(IOrderRepository iOrderRepository, OrderedProductService orderedProductService) {
        this.iOrderRepository = iOrderRepository;
        this.orderedProductService = orderedProductService;
    }

    public void start(Integer userId, NewOrderRequest newOrderRequest) {
        Order order = new Order();
        order.setUserId(userId);
        order.setPaymentType(newOrderRequest.paymentType());
        iOrderRepository.save(order);
        orderedProductService.create(newOrderRequest.relationOrderedProductDtoList(), order);
    }

    public OrderDto getActiveOrder(Integer userId) {
        Order activeOrder = iOrderRepository.findFirstByUserIdAndOrderState(userId, OrderStateEnum.PROCESSING)
                .orElseThrow(
                        () -> new ActiveOrderNotFoundException(
                                "There is no active order for user with id: " + userId)
                );
        return OrderDto.convert(activeOrder);
    }

    public List<OrderDto> getAllOrders(Integer userId){
        return iOrderRepository
                .findAllByUserId(userId)
                .stream()
                .map(OrderDto::convert)
                .toList();
    }

    public void updateOrderState(Long orderId, OrderStateEnum orderState) {
        Order order = findById(orderId);
        order.setOrderState(orderState);
        iOrderRepository.save(order);
    }

    public void updatePaymentState(Long orderId, PaymentStateEnum paymentState) {
        Order order = findById(orderId);
        order.setPaymentState(paymentState);
        iOrderRepository.save(order);
    }

    private Order findById(Long orderId){
        return iOrderRepository.findById(orderId).orElseThrow(
                () -> new ActiveOrderNotFoundException(
                        "There is no active order with id: " + orderId)
        );
    }
}
