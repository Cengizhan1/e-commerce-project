package com.cengizhan.ecommerceproject.orderservice.entity;

import com.cengizhan.ecommerceproject.orderservice.entity.enums.OrderStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentTypeEnum;
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
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "user_id",unique = true,nullable = false)
    private Integer userId;

    @OneToMany(mappedBy = "relationOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<OrderedProduct> relationOrderedProductList;

    @Enumerated(EnumType.STRING)
    private OrderStateEnum orderState = OrderStateEnum.NEW;

    @Enumerated(EnumType.STRING)
    private PaymentStateEnum paymentState = PaymentStateEnum.PENDING;

    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType;
}
