package com.cengizhan.ecommerceproject.orderservice.entity;

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
@Table(name = "ordered_products")
public class OrderedProduct extends BaseEntity {

    private String name;
    private String description;
    private String descriptionShort;
    private Float price;
    private String code;

    @Column(name = "product_id",nullable = false)
    private Long productId;

    @ManyToOne(optional = false)
    @JoinColumn(name="order_id",nullable = false)
    private Order relationOrder;


}
