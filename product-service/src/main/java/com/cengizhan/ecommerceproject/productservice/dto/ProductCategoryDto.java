package com.cengizhan.ecommerceproject.productservice.dto;


import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ProductCategoryDto(
        Long id,
        @NotEmpty(message = "{name.validation.constraints.NotNull.message}")
        @Size(min = 10, message = "{name.validation.constraints.minLength.message}")
        String name,
        @NotEmpty(message = "{description_short.validation.constraints.NotNull.message}")
        @Size(min = 10, message = "{description_short.validation.constraints.minLength.message}")
        String description_short,
        @Size(min = 10, message = "{description.validation.constraints.minLength.message}")
        String description
) {
    public static ProductCategoryDto convert(ProductCategory productCategory) {
        return new ProductCategoryDto(
                productCategory.getId(),
                productCategory.getName(),
                productCategory.getDescription_short(),
                productCategory.getDescription()
        );
    }
}
