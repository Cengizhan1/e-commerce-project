package com.cengizhan.ecommerceproject.walletservice.controller;

import org.springframework.http.ResponseEntity;

public interface IWalletApi<D> {

    // C R U D
    // CREATE
    public ResponseEntity<?> walletApiCreate(D d);

    // Find By Id
    public ResponseEntity<?> walletApiFindById(Long id);
    // Find By User Id
    public ResponseEntity<?> walletApiFindByUserId(Integer userId);

    // UPDATE BALANCE
    public ResponseEntity<?> walletApiBalanceUpdate(Integer userId, Float amount);
}
