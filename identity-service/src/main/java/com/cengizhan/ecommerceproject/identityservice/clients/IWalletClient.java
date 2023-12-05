package com.cengizhan.ecommerceproject.identityservice.clients;

import com.cengizhan.ecommerceproject.identityservice.clients.classes.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "wallet-service", url = "http://localhost:8765/wallet-service/api/v1/wallet")
public interface IWalletClient {

    @PostMapping("/create")
    public Wallet createWallet(@RequestBody Wallet wallet, @RequestHeader("Authorization") String authorizationHeader);
}
