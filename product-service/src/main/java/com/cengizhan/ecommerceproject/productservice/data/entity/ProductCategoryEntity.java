package com.cengizhan.ecommerceproject.productservice.data.entity;

import com.cengizhan.ecommerceproject.productservice.data.BaseEntity;
import com.cengizhan.ecommerceproject.productservice.enums.StockState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategoryEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;
    @Column(name = "description_short")
    private String description_short;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "relationProductCategoryEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ProductEntity> relationProductEntityList;

}
