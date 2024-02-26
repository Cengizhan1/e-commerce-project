package com.cengizhan.ecommerceproject.identityservice.clients.classes;

import com.cengizhan.ecommerceproject.identityservice.entity.enums.StockState;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "{name.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{name.validation.constraints.minLength.message}")
    private String name;

    @NotEmpty(message = "{description_short.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{description_short.validation.constraints.minLength.message}")
    private String description_short;

    @Size(min = 10, message = "{description.validation.constraints.minLength.message}")
    private String description;

    @NotEmpty(message = "{price.validation.constraints.NotNull.message}")
    @Min(value = 0, message = "{price.validation.constraints.Min.message}")
    private Float price;

    private StockState stockState;

    private Integer stockCount;

    private String code;

    private Float avgRating;
    @NotEmpty(message = "{categoryId.validation.constraints.NotNull.message}")
    private Long categoryId;
    @NotEmpty(message = "{user_id.validation.constraints.NotNull.message}")
    private Integer userId;
}
