package com.cengizhan.ecommerceproject.walletservice.data.repository;

import com.cengizhan.ecommerceproject.walletservice.data.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IWalletRepository  extends CrudRepository<WalletEntity,Long> {

    Optional<WalletEntity> findByUserId(Integer userId);
}
