package com.cengizhan.ecommerceproject.productservice.business.service;

import java.util.List;

public interface IProductCategoryService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D productCategoryServiceCreate(D d);

    // LIST
    public List<D> productCategoryServiceList();

    // FIND BY
    public D productCategoryServiceFindById(Long id);

    // UPDATE
    public D productCategoryServiceUpdate(Long id,D d);

    // DELETE
    public D productCategoryServiceDeleteById(Long id);

    // All DELETE
    public D productCategoryServiceDeleteAll();

}
