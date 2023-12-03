package com.cengizhan.ecommerceproject.identityservice.business.service;

public interface IUserService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // FIND BY
    public D userServiceFindById(Integer id);


}
