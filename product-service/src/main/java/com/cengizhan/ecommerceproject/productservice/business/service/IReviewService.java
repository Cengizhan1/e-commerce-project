package com.cengizhan.ecommerceproject.productservice.business.service;

import java.util.List;

public interface IReviewService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D reviewServiceCreate(D d);

    // FIND BY
    public D reviewServiceFindById(Long id);

    // LIST
    public List<D> reviewServiceListByProductId(Long id);

    // UPDATE
    public D reviewServiceUpdate(Long id,D d);

    // DELETE
    public D reviewServiceDeleteById(Long id);
}
