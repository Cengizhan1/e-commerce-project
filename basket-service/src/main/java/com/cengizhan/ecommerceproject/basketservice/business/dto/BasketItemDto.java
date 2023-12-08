package com.cengizhan.ecommerceproject.basketservice.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BasketItemDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    private Short quantity;
    private Long categoryId;
}
