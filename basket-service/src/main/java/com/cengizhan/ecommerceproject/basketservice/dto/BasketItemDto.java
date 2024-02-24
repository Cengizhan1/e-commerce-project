package com.cengizhan.ecommerceproject.basketservice.dto;

import com.cengizhan.ecommerceproject.basketservice.entity.BasketItem;


public record BasketItemDto(
        Long productId,
        Short quantity
) {
    public static BasketItemDto convert(BasketItem basketItem) {
        return new BasketItemDto(basketItem.getProductId(), basketItem.getQuantity());
    }
}
