package com.cengizhan.ecommerceproject.orderservice.service;

import com.cengizhan.ecommerceproject.orderservice.dto.OrderedProductDto;
import com.cengizhan.ecommerceproject.orderservice.entity.Order;
import com.cengizhan.ecommerceproject.orderservice.entity.OrderedProduct;
import com.cengizhan.ecommerceproject.orderservice.repository.IOrderedProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderedProductService {

    private final IOrderedProductRepository iOrderedProductRepository;

    public OrderedProductService(IOrderedProductRepository iOrderedProductRepository) {
        this.iOrderedProductRepository = iOrderedProductRepository;
    }

    protected void create(List<OrderedProductDto> orderedProductDtoList, Order order) {
        List<OrderedProduct> orderedProductList = new ArrayList<>();
        for (OrderedProductDto orderedProductDto : orderedProductDtoList) {
            OrderedProduct orderedProduct = new OrderedProduct(
                    orderedProductDto.name(),
                    orderedProductDto.description(),
                    orderedProductDto.descriptionShort(),
                    orderedProductDto.price(),
                    orderedProductDto.code(),
                    orderedProductDto.productId(),
                    order
            );
            orderedProductList.add(orderedProduct);
        }
        iOrderedProductRepository.saveAll(orderedProductList);
    }
}
