package com.cengizhan.ecommerceproject.basketservice.service;

import com.cengizhan.ecommerceproject.basketservice.dto.BasketItemDto;
import com.cengizhan.ecommerceproject.basketservice.entity.Basket;
import com.cengizhan.ecommerceproject.basketservice.entity.BasketItem;
import com.cengizhan.ecommerceproject.basketservice.repository.IBasketRepository;
import com.cengizhan.ecommerceproject.basketservice.exception.BasketNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class BasketService{

    private final IBasketRepository iBasketRepository;
    private final BasketItemService basketItemService;

    public void basketCreate(Integer userId) {
        if(!iBasketRepository.existsByUserId(userId)){
            Basket basket = new Basket();
            basket.setUserId(userId);
            iBasketRepository.save(basket);
        }
    }

    public void addProductToBasket(Long productId, Short quantity, Integer userId) {
        basketItemService.create(productId, quantity,findBasketByUserId(userId));
    }

    
    public void removeProductFromBasket(Integer userId, Long productId) {
        Basket basket = findBasketByUserId(userId);
        basketItemService.delete(productId, basket.getId());
    }

    
    public void clearBasket(Integer userId) {
        Basket basket = findBasketByUserId(userId);
        basketItemService.deleteAllByBasketId(basket.getId());
    }


    
    public List<BasketItemDto> listProductsInBasket(Integer userId) {
        Basket basket = findBasketByUserId(userId);
        List<BasketItem> basketItems = basketItemService.findAllByBasketId(basket.getId());
        return basketItems.stream().map(BasketItemDto::convert).toList();
    }

    
//    public BasketItemDto showBasketSummary(Long basketId) {
//        return null;
//    }

    
    private Basket findBasketByUserId(Integer userId) {
        return iBasketRepository.findByUserId(userId).orElseThrow(
                ()-> new BasketNotFoundException("Basket not found for user: " + userId));
    }
}
