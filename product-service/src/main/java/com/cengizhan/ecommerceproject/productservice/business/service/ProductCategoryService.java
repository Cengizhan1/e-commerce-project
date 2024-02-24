package com.cengizhan.ecommerceproject.productservice.business.service;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductCategoryDto;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProductCategoryService {

    private final IProductCategoryRepository iProductCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    
    public ProductCategoryDto entityToDto(ProductCategory ProductCategory) {
        return modelMapperBean.modelMapperMethod().map(ProductCategory,ProductCategoryDto.class);
    }

    
    public ProductCategory dtoToEntity(ProductCategoryDto productCategoryDto) {
        return  modelMapperBean.modelMapperMethod().map(productCategoryDto,ProductCategory.class);
    }

    // LIST
    public List<ProductCategoryDto> categoryList() {
        Iterable<ProductCategory> entityIterable = iProductCategoryRepository.findAll();
        List<ProductCategoryDto> productCategoryDtoList = new ArrayList<>();
        for (ProductCategory entity : entityIterable) {
            ProductCategoryDto productCategoryDto = entityToDto(entity);
            productCategoryDtoList.add(productCategoryDto);
        }
        return productCategoryDtoList;
    }



}
