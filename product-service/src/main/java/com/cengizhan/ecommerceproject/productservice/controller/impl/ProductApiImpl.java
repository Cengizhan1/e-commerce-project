package com.cengizhan.ecommerceproject.productservice.controller.impl;


import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductService;
import com.cengizhan.ecommerceproject.productservice.controller.IProductApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

// API
@RestController
//@CrossOrigin(origins = FrontendUrl.REACT_URL)
@RequestMapping("/product/api/v1")
public class ProductApiImpl implements IProductApi<ProductDto> {
    // injection
    private final IProductService iProductService;

    // CREATE
    // /product/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> productApiCreate(@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(iProductService.productServiceCreate(productDto));
    }

    // LIST
    // /product/api/v1/list
    @Override
    @GetMapping(value = "/list/{categoryId}")
    public ResponseEntity<List<ProductDto>> productApiList(@PathVariable(name = "categoryId") Long categoryId) {
       return ResponseEntity.ok(iProductService.productServiceListByCategory(categoryId));
    }

    @Override
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> productApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(iProductService.productServiceFindById(id));
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> productApiUpdate(@PathVariable(name = "id") Long id,@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.status(200).body(iProductService.productServiceUpdate(id, productDto));
        }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> productApiDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iProductService.productServiceDeleteById(id));
    }

    @Override
    @DeleteMapping(value = "/all/delete")
    public ResponseEntity<?> productApiAllDelete() {
        return ResponseEntity.status(200).body(iProductService.productServiceDeleteAll());
    }
}
