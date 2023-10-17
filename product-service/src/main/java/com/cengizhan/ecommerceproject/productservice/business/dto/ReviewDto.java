    package com.cengizhan.ecommerceproject.productservice.business.dto;

    import com.cengizhan.ecommerceproject.productservice.enums.StockState;
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
    public class ReviewDto implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private Long id;

        @NotEmpty(message ="{review.validation.constraints.NotNull.message}")
        @Size(min=3,message = "{review.validation.constraints.minLength.message}")
        private String review;

//        @NotEmpty(message ="{userId.validation.constraints.NotNull.message}")
//        private Integer userId;

        @NotEmpty(message ="{rating.validation.constraints.NotNull.message}")
        private Integer rating;

        @NotEmpty(message ="{productId.validation.constraints.NotNull.message}")
        private Long productId;
    }
