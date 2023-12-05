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
@Table(name = "products")
public class ProductEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;
    @Column(name = "description_short")
    private String description_short;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Float price;
    @Column(name = "stock_state")
    private StockState stockState;
    @Column(name = "stock_count")
    private Integer stockCount;
    @Column(name = "code")
    private String code;
    @Column(name = "avg_rating")
    private Float avgRating;
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(optional = false)
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategoryEntity relationProductCategoryEntity;


    @OneToMany(mappedBy = "relationProductEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ReviewEntity> relationReviewEntityList;

}
