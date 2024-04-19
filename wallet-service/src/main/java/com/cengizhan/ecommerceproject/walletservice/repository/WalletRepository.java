package com.cengizhan.ecommerceproject.walletservice.repository;

import com.cengizhan.ecommerceproject.walletservice.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findByUserId(Integer userId);
}
