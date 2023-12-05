package com.cengizhan.ecommerceproject.walletservice.data.entity;


import com.cengizhan.ecommerceproject.walletservice.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallets")
public class WalletEntity extends BaseEntity {


    @Column(name = "user_id", unique = true)
    private Integer userId;
    @Column(name = "balance")
    private Float balance;
}
