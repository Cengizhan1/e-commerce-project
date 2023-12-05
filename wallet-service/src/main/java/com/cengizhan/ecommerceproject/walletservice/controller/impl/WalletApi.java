package com.cengizhan.ecommerceproject.walletservice.controller.impl;

import com.cengizhan.ecommerceproject.walletservice.business.dto.WalletDto;
import com.cengizhan.ecommerceproject.walletservice.business.service.IWalletService;
import com.cengizhan.ecommerceproject.walletservice.controller.IWalletApi;
import com.cengizhan.ecommerceproject.walletservice.data.entity.WalletEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wallet-service/api/v1/wallet")
@RequiredArgsConstructor
public class WalletApi implements IWalletApi<WalletDto> {

    private final IWalletService<WalletDto, WalletEntity> iWalletService;
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> walletApiCreate(@Valid @RequestBody WalletDto walletDto) {
        return ResponseEntity.ok().body(iWalletService.walletServiceCreate(walletDto));
    }

    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> walletApiFindById(@PathVariable(name = "id" ) Long id) {
        return ResponseEntity.ok().body(iWalletService.walletServiceFindById(id));
    }

    @Override
    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<?> walletApiFindByUserId(@PathVariable(name = "userId") Integer userId) {
        return ResponseEntity.ok().body(iWalletService.walletServiceFindByUserId(userId));
    }

    @Override
    @PutMapping("/balanceUpdate/{userId}")
    public ResponseEntity<?> walletApiBalanceUpdate(@PathVariable(name = "userId") Integer userId,@RequestBody Float amount) {
        return ResponseEntity.ok().body(iWalletService.wallerServiceBalanceUpdate(userId, amount));
    }
}
