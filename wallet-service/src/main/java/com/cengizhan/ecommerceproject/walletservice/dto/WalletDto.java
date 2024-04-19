package com.cengizhan.ecommerceproject.walletservice.dto;

import com.cengizhan.ecommerceproject.walletservice.entity.Wallet;
import jakarta.validation.constraints.NotEmpty;


public record WalletDto(
        Long id,
        @NotEmpty
        Integer userId,
        Float balance
) {
        public static WalletDto convert(Wallet wallet) {
                return new WalletDto(
                        wallet.getId(),
                        wallet.getUserId(),
                        wallet.getBalance()
                );
        }
}
