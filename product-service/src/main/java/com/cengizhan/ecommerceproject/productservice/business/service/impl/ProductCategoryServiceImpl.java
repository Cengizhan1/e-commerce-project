package com.cengizhan.ecommerceproject.productservice.business.service.impl;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductCategoryDto;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductCategoryService;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductService;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductCategoryEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.exception.CustomException;
import com.cengizhan.ecommerceproject.productservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService<ProductCategoryDto, ProductCategoryEntity> {

    private final IProductCategoryRepository iProductCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public ProductCategoryDto entityToDto(ProductCategoryEntity productCategoryEntity) {
        return modelMapperBean.modelMapperMethod().map(productCategoryEntity,ProductCategoryDto.class);
    }

    @Override
    public ProductCategoryEntity dtoToEntity(ProductCategoryDto productCategoryDto) {
        return  modelMapperBean.modelMapperMethod().map(productCategoryDto,ProductCategoryEntity.class);
    }

    // CREATE
    @Override
    @Transactional // create, delete, update
    public ProductCategoryDto productCategoryServiceCreate(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto != null) {
            ProductCategoryEntity productCategoryEntity = dtoToEntity(productCategoryDto);
            iProductCategoryRepository.save(productCategoryEntity);
            productCategoryDto.setId(productCategoryEntity.getId());
        } else {
            throw new NullPointerException("ProductCategoryDto null veri");
        }
        return productCategoryDto;
    }

    // LIST
    @Override
    public List<ProductCategoryDto> productCategoryServiceList() {
        Iterable<ProductCategoryEntity> entityIterable = iProductCategoryRepository.findAll();
        List<ProductCategoryDto> productCategoryDtoList = new ArrayList<>();
        for (ProductCategoryEntity entity : entityIterable) {
            ProductCategoryDto productCategoryDto = entityToDto(entity);
            productCategoryDtoList.add(productCategoryDto);
        }
        return productCategoryDtoList;
    }

    // FIND
    @Override
    public ProductCategoryDto productCategoryServiceFindById(Long id) {
        ProductCategoryEntity findProductCategoryEntity = null;
        if (id != null) {
            findProductCategoryEntity = iProductCategoryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findProductCategoryEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public ProductCategoryDto productCategoryServiceUpdate(Long id, ProductCategoryDto productCategoryDto) {
        ProductCategoryDto productCategoryFindDto = productCategoryServiceFindById(id);
        if (productCategoryFindDto != null) {
            ProductCategoryEntity productCategoryEntity = dtoToEntity(productCategoryFindDto);
            productCategoryEntity.setName(productCategoryDto.getName());
            productCategoryEntity.setDescription_short(productCategoryDto.getDescription_short());
            productCategoryEntity.setDescription(productCategoryDto.getDescription());
            iProductCategoryRepository.save(productCategoryEntity);
        }
        return productCategoryDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public ProductCategoryDto productCategoryServiceDeleteById(Long id) {
        ProductCategoryDto productCategoryFindDto = productCategoryServiceFindById(id);
        if (productCategoryFindDto != null) {
            iProductCategoryRepository.deleteById(id);
        }
        return productCategoryFindDto;


    }

    @Override
    @Transactional // create, delete, update
    public ProductCategoryDto productCategoryServiceDeleteAll() {
        iProductCategoryRepository.deleteAll();
        return null;
    }
}
