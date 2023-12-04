package com.cengizhan.ecommerceproject.productservice.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductApi<D> {
    // C R U D
    // CREATE
    public ResponseEntity<?> productApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  productApiList(Long categoryId,Integer userId);

    // FIND BY
    public ResponseEntity<?>  productApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?>  productApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?>  productApiDeleteById(Long id);

    //////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<?> productApiAllDelete();

    public ResponseEntity<List<D>>  productApiListByUserId(Integer userId);


}
