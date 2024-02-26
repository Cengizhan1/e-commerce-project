    package com.cengizhan.ecommerceproject.productservice.dto;

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
    public class ProductCategoryDto implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private Long id;

        @NotEmpty(message ="{name.validation.constraints.NotNull.message}")
        @Size(min=10,message = "{name.validation.constraints.minLength.message}")
        private String name;

        @NotEmpty(message ="{description_short.validation.constraints.NotNull.message}")
        @Size(min=10,message = "{description_short.validation.constraints.minLength.message}")
        private String description_short;

        @Size(min=10,message = "{description.validation.constraints.minLength.message}")
        private String description;
    }
