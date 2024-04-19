package com.cengizhan.ecommerceproject.basketservice.entity;

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
@Table(name = "baskets")
public class Basket extends BaseEntity {

    @Column(name = "user_id",unique = true,nullable = false)
    private Integer userId;

    @OneToMany(mappedBy = "relationBasket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<BasketItem> relationBasketItemList;


}
