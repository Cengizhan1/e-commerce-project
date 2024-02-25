package com.cengizhan.ecommerceproject.orderservice.dto;

import com.cengizhan.ecommerceproject.orderservice.entity.Order;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.OrderStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentTypeEnum;

import java.util.List;

public record OrderDto(
        List<OrderedProductDto> relationOrderedProductDtoList,
        OrderStateEnum orderState,
        PaymentStateEnum paymentState,
        PaymentTypeEnum paymentType
) {
    public static OrderDto convert(Order order) {
        return new OrderDto(
                order.getRelationOrderedProductList().stream().map(OrderedProductDto::convert).toList(),
                order.getOrderState(),
                order.getPaymentState(),
                order.getPaymentType()
        );
    }
}
