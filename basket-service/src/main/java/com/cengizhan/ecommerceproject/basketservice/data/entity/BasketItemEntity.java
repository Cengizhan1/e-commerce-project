package com.cengizhan.ecommerceproject.basketservice.data.entity;

import com.cengizhan.ecommerceproject.basketservice.data.BaseEntity;
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
public class BasketItemEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id",nullable = false)
    private Long productId;

    @Column(name = "quantity",nullable = false)
    private Short quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name="basket_id",nullable = false)
    private BasketEntity relationBasketEntity;


}
