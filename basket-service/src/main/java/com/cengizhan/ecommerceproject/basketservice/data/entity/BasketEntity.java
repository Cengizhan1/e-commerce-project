package com.cengizhan.ecommerceproject.basketservice.data.entity;

import com.cengizhan.ecommerceproject.basketservice.data.BaseEntity;
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
public class BasketEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "user_id",unique = true,nullable = false)
    private Integer userId;

    @OneToMany(mappedBy = "relationBasketEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<BasketItemEntity> relationBasketItemEntityList;


}
