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

@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_id",nullable = false)
    private ProductEntity relationProductEntity;

    // user relation will be added later
    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private Integer rating;
}