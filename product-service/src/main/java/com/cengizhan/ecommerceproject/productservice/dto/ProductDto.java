package com.cengizhan.ecommerceproject.productservice.dto;

import com.cengizhan.ecommerceproject.productservice.entity.Product;
import com.cengizhan.ecommerceproject.productservice.entity.enums.StockState;

public record ProductDto(
        Long id,
        String name,
        String description_short,
        String description,
        Float price,
        StockState stockState,
        Integer stockCount,
        String code,
        Float avgRating
) {

    public static ProductDto convert(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription_short(),
                product.getDescription(),
                product.getPrice(),
                product.getStockState(),
                product.getStockCount(),
                product.getCode(),
                product.getAvgRating()
        );
    }

}
