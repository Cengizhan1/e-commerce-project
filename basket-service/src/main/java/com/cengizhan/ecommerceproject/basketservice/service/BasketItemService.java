package com.cengizhan.ecommerceproject.basketservice.service;

import com.cengizhan.ecommerceproject.basketservice.entity.Basket;
import com.cengizhan.ecommerceproject.basketservice.entity.BasketItem;
import com.cengizhan.ecommerceproject.basketservice.repository.IBasketItemRepository;
import com.cengizhan.ecommerceproject.basketservice.exception.BasketItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketItemService {

    private final IBasketItemRepository iBasketItemRepository;

    public BasketItemService(IBasketItemRepository iBasketItemRepository) {
        this.iBasketItemRepository = iBasketItemRepository;
    }

    protected void create(Long productId, Short quantity, Basket basket) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(productId);
        basketItem.setQuantity(quantity);
        basketItem.setRelationBasket(basket);
        iBasketItemRepository.save(basketItem);
    }

    public List<BasketItem> findAllByBasketId(Long basketId) {
        return iBasketItemRepository.findAllByRelationBasketId(basketId);
    }

    protected void delete(Long productId, Long basketId) {
        BasketItem basketItem = iBasketItemRepository.
                findFirstByProductIdAndRelationBasketId(productId, basketId).orElseThrow(
                        () -> new BasketItemNotFoundException(
                                "Basket item not found for product: " + productId)
                );
        System.out.println("qlwödlqwö");
        System.out.println(basketItem.getQuantity());
        iBasketItemRepository.delete(basketItem);
    }

    protected void deleteAllByBasketId(Long basketId) {
        iBasketItemRepository.deleteAllByRelationBasketId(basketId);
    }
}
