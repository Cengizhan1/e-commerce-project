package com.cengizhan.ecommerceproject.identityservice.clients;

import com.cengizhan.ecommerceproject.identityservice.clients.classes.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "wallet-service", url = "http://localhost:8765/wallet-service/api/v1/wallet")
public interface IWalletClient {

    @PostMapping("/create")
    public Wallet createWallet(@RequestBody Wallet wallet, @RequestHeader("Authorization") String authorizationHeader);

    @GetMapping("/find/{id}")
    public Wallet getWallet(@PathVariable(name = "id" ) Long id, @RequestHeader("Authorization") String authorizationHeader);

    @GetMapping("/findByUserId/{userId}")
    public Wallet getWalletByUserId(@PathVariable(name = "userId") Integer userId, @RequestHeader("Authorization") String authorizationHeader);

    @PutMapping("/balanceUpdate/{userId}")
    public Wallet updateWalletBalance(@PathVariable(name = "userId") Integer userId,@RequestBody Float amount, @RequestHeader("Authorization") String authorizationHeader);
}
