package com.cengizhan.ecommerceproject.identityservice.business.service;

import com.cengizhan.ecommerceproject.identityservice.clients.IWalletClient;
import com.cengizhan.ecommerceproject.identityservice.clients.classes.Wallet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class WalletService extends BaseService {
    private final IWalletClient iWalletClient;

    
    public Wallet walletServiceCreate() {
        Wallet wallet = new Wallet();
        wallet.setUserId(this.getUserId());
        wallet.setBalance(0f);
        return iWalletClient.createWallet(wallet, this.getBearerToken());
    }


    
    public Wallet walletServiceFindById(Long id) {
        return iWalletClient.getWallet(id, this.getBearerToken());
    }

    
    public Wallet walletServiceFindByUserId(Integer userId) {
        return iWalletClient.getWalletByUserId(userId, this.getBearerToken());
    }

    
    public Wallet wallerServiceBalanceUpdate(Integer userId, Float amount) {
        return iWalletClient.updateWalletBalance(userId, amount, this.getBearerToken());
    }
}
