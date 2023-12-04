package com.cengizhan.ecommerceproject.productservice.business.service;

import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;

import java.util.List;

public interface IProductService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D productServiceCreate(D d);

    // LIST
    public List<D> productServiceListByCategory(Long productCategoryId);

    // FIND BY
    public D productServiceFindById(Long id);

    // UPDATE
    public D productServiceUpdate(Long id,D d);

    // DELETE
    public D productServiceDeleteById(Long id);

    // All DELETE
    public D productServiceDeleteAll();

    public List<D> productServiceListByUserId(Integer userId);

}
