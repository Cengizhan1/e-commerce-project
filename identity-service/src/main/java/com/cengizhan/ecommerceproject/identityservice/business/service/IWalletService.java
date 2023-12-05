package com.cengizhan.ecommerceproject.identityservice.business.service;

public interface IWalletService<D> {


    public D walletServiceCreate();

    public D walletServiceFindById(Long id);

    public D walletServiceFindByUserId(Integer userId);
    
    public D wallerServiceBalanceUpdate(Integer userId, Float amount);
}
