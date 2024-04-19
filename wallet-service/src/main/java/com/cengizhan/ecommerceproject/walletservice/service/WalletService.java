package com.cengizhan.ecommerceproject.walletservice.service;

import com.cengizhan.ecommerceproject.walletservice.dto.WalletDto;
import com.cengizhan.ecommerceproject.walletservice.exception.WalletNotFoundException;
import com.cengizhan.ecommerceproject.walletservice.entity.Wallet;
import com.cengizhan.ecommerceproject.walletservice.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletDto walletServiceCreate(Integer userId) {
        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        walletRepository.save(wallet);
        return WalletDto.convert(wallet);
    }

    public WalletDto walletServiceFindByUserId(Integer userId) {
        return WalletDto.convert(findWallet(userId));
    }


    public WalletDto wallerServiceBalanceUpdate(Integer userId, Float amount) {
        Wallet wallet = findWallet(userId);
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);
        return WalletDto.convert(wallet);
    }

    private Wallet findWallet(Integer userId) {
        return walletRepository.findByUserId(userId)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found for user id: " + userId));
    }
}
