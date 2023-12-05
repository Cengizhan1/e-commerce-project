package com.cengizhan.ecommerceproject.identityservice.business.service.impl;

import com.cengizhan.ecommerceproject.identityservice.business.service.IWalletService;
import com.cengizhan.ecommerceproject.identityservice.clients.classes.Wallet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class WalletService extends BaseService implements IWalletService<Wallet> {

    private final IWalletService<Wallet> iWalletService;

    @Override
    public Wallet walletServiceCreate(Wallet wallet) {
        return null;
    }


    @Override
    public Wallet walletServiceFindById(Long id) {
        return null;
    }

    @Override
    public Wallet walletServiceFindByUserId(Integer userId) {
        return null;
    }

    @Override
    public Wallet wallerServiceBalanceUpdate(Integer userId, Float amount) {
        return null;
    }
}
