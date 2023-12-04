package com.cengizhan.ecommerceproject.identityservice.business.service;

import com.cengizhan.ecommerceproject.identityservice.clients.Product;

import java.util.List;

public interface IUserService<D,E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // FIND BY
    public D userServiceFindById(Integer id);

    public List<Product> listUserProducts();

    public Product showProduct(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Product product,Long id);

    public Product deleteProduct(Long id);


}
