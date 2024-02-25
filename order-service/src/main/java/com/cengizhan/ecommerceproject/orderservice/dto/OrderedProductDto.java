package com.cengizhan.ecommerceproject.orderservice.dto;

import com.cengizhan.ecommerceproject.orderservice.entity.OrderedProduct;

public record OrderedProductDto(
        Long productId,
        Long orderId,
        String name,
        String description,
        String descriptionShort,
        Float price,
        String code) {

    public static OrderedProductDto convert(OrderedProduct orderedProduct) {
        return new OrderedProductDto(
                orderedProduct.getProductId(),
                orderedProduct.getRelationOrder().getId(),
                orderedProduct.getName(),
                orderedProduct.getDescription(),
                orderedProduct.getDescriptionShort(),
                orderedProduct.getPrice(),
                orderedProduct.getCode()
        );

    }
}
