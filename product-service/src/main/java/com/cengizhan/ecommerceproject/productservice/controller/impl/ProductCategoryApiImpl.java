package com.cengizhan.ecommerceproject.productservice.controller.impl;

import com.cengizhan.ecommerceproject.productservice.business.dto.ProductCategoryDto;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductCategoryService;
import com.cengizhan.ecommerceproject.productservice.controller.IProductCategoryApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

// API
@RestController
//@CrossOrigin(origins = FrontendUrl.REACT_URL)
@RequestMapping("/product-service/product-category/api/v1")
public class ProductCategoryApiImpl implements IProductCategoryApi<ProductCategoryDto> {
    // injection
    private final IProductCategoryService iProductCategoryService;

    // CREATE
    // /product-category/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> productCategoryApiCreate(@Valid @RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity.ok(iProductCategoryService.productCategoryServiceCreate(productCategoryDto));
    }

    // LIST
    // /product-category/api/v1/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<ProductCategoryDto>> productCategoryApiList() {
       return ResponseEntity.ok(iProductCategoryService.productCategoryServiceList());
    }

    @Override
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> productCategoryApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(iProductCategoryService.productCategoryServiceFindById(id));
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> productCategoryApiUpdate(@PathVariable(name = "id") Long id,@Valid @RequestBody ProductCategoryDto productCategoryDto) {
        return ResponseEntity.status(200).body(iProductCategoryService.productCategoryServiceUpdate(id, productCategoryDto));
        }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> productCategoryApiDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iProductCategoryService.productCategoryServiceDeleteById(id));
    }

    @Override
    @DeleteMapping(value = "/all/delete")
    public ResponseEntity<?> productCategoryApiAllDelete() {
        return ResponseEntity.status(200).body(iProductCategoryService.productCategoryServiceDeleteAll());
    }
    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }
}
