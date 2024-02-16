package com.cengizhan.ecommerceproject.basketservice.business.service.impl;

import com.cengizhan.ecommerceproject.basketservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.basketservice.business.dto.BasketDto;
import com.cengizhan.ecommerceproject.basketservice.business.service.IBasketService;
import com.cengizhan.ecommerceproject.basketservice.data.BaseEntity;
import com.cengizhan.ecommerceproject.basketservice.data.entity.BasketEntity;
import com.cengizhan.ecommerceproject.basketservice.data.repository.IBasketItemRepository;
import com.cengizhan.ecommerceproject.basketservice.data.repository.IBasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class BasketService implements IBasketService<BasketDto, BasketEntity> {


    private final ModelMapperBean modelMapperBean;
    private final IBasketRepository iBasketRepository;
    private final IBasketItemRepository iBasketItemRepository;

    @Override
    public BasketDto entityToDto(BasketEntity basketEntity) {
        return modelMapperBean.modelMapperMethod().map(basketEntity,BasketDto.class);
    }

    @Override
    public BasketEntity dtoToEntity(BasketDto basketDto) {
        return modelMapperBean.modelMapperMethod().map(basketDto,BasketEntity.class);
    }

    @Override
    public BasketDto basketServiceCreate(BasketDto basketDto) {
      return null;
    }

    @Override
    public BasketDto addProductToBasket(BasketDto basketDto, Long productId, Integer quantity) {
        return null;
    }

    @Override
    public BasketDto removeProductFromBasket(BasketDto basketDto, Long productId) {
        return null;
    }

    @Override
    public BasketDto removeAllProductsFromBasket(Long basketId) {
        return null;
    }


    @Override
    public List<BasketDto> listProductsInBasket(Long basketId) {
        return null;
    }

    @Override
    public BasketDto showBasketSummary(Long basketId) {
        return null;
    }

    @Override
    public String test() {
        return "test";
    }
}
