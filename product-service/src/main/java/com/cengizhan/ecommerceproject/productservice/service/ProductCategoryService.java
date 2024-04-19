package com.cengizhan.ecommerceproject.productservice.service;

import com.cengizhan.ecommerceproject.productservice.dto.ProductCategoryDto;
import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.repository.ProductCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategoryDto> categoryList() {
        return productCategoryRepository.findAll().stream().map(ProductCategoryDto::convert).toList();
    }
}
