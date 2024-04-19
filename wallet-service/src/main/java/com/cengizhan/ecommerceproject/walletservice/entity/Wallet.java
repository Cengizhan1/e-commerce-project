package com.cengizhan.ecommerceproject.walletservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wallets")
public class Wallet extends BaseEntity {

    @Column(name = "user_id", unique = true)
    private Integer userId;
    @Column(name = "balance")
    private Float balance = 0f;
}
