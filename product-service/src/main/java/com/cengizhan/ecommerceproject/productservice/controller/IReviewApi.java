package com.cengizhan.ecommerceproject.productservice.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReviewApi<D> {
    // C R U D
    // CREATE
    public ResponseEntity<?>reviewApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> reviewApiListByProduct(Long productId);

    // FIND BY
//    public ResponseEntity<?> reviewApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?> reviewApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?> reviewApiDeleteById(Long id);



}
