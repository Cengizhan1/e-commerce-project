package com.cengizhan.ecommerceproject.walletservice.controller;

import com.cengizhan.ecommerceproject.walletservice.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/wallet")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> create(@PathVariable(name = "userId") Integer userId) {
        return ResponseEntity.ok().body(service.walletServiceCreate(userId));
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable(name = "userId") Integer userId) {
        return ResponseEntity.ok().body(service.walletServiceFindByUserId(userId));
    }

    @PutMapping("/balanceUpdate/{userId}")
    public ResponseEntity<?> balanceUpdate(@PathVariable(name = "userId") Integer userId,@RequestBody Float amount) {
        return ResponseEntity.ok().body(service.wallerServiceBalanceUpdate(userId, amount));
    }
}
