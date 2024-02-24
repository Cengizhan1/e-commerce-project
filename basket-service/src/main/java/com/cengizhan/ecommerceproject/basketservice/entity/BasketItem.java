package com.cengizhan.ecommerceproject.basketservice.entity;

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
@Table(name = "basket_items")
public class BasketItem extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id",nullable = false)
    private Long productId;

    @Column(name = "quantity",nullable = false)
    private Short quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name="basket_id",nullable = false)
    private Basket relationBasket;


}
