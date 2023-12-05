package com.cengizhan.ecommerceproject.walletservice.business.service;

public interface IWalletService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    public D walletServiceCreate(D d);

    public D walletServiceFindById(Long id);

    public D walletServiceFindByUserId(Integer userId);
    
    public D wallerServiceBalanceUpdate(Integer userId, Float amount);
}
