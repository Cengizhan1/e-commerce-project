package com.cengizhan.ecommerceproject.identityservice.controller.impl;

import com.cengizhan.ecommerceproject.identityservice.business.service.IWalletService;
import com.cengizhan.ecommerceproject.identityservice.clients.classes.Product;
import com.cengizhan.ecommerceproject.identityservice.clients.classes.Wallet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identity-service/api/v1/wallet")
@RequiredArgsConstructor
public class WalletApi {
    private final IWalletService<Wallet> iWalletService;
    @PostMapping("/create")
    public ResponseEntity<?> walletCreate() {
        return ResponseEntity.ok().body(iWalletService.walletServiceCreate());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> walletFindById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(iWalletService.walletServiceFindById(id));
    }
    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<?> walletFindByUserId(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok().body(iWalletService.walletServiceFindByUserId(userId));
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> walletUpdate(@PathVariable("userId") Integer userId, @RequestParam("amount") Float amount) {
        System.out.println("controller başladı");
        return ResponseEntity.ok().body(iWalletService.wallerServiceBalanceUpdate(userId, amount));
    }
}
