package com.cengizhan.ecommerceproject.orderservice.dto;

import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentTypeEnum;

import java.util.List;

public record NewOrderRequest(
    List<OrderedProductDto> relationOrderedProductDtoList,
    PaymentTypeEnum paymentType
) {}
