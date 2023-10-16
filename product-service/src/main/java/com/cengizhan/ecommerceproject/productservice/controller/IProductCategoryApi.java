package com.cengizhan.ecommerceproject.productservice.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductCategoryApi<D> {
    // C R U D
    // CREATE
    public ResponseEntity<?> productCategoryApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  productCategoryApiList();

    // FIND BY
    public ResponseEntity<?>  productCategoryApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?>  productCategoryApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?>  productCategoryApiDeleteById(Long id);

    //////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<?> productCategoryApiAllDelete();

}
