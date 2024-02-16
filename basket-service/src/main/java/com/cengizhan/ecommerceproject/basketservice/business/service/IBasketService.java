package com.cengizhan.ecommerceproject.basketservice.business.service;

import java.util.List;

public interface IBasketService<D,E> {
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    public D basketServiceCreate(D d);

    D addProductToBasket(D d, Long productId, Integer quantity);

    D removeProductFromBasket(D d, Long productId);

    D removeAllProductsFromBasket(Long basketId);

    List<D> listProductsInBasket(Long basketId);

    D showBasketSummary(Long basketId);

    String test();


}
