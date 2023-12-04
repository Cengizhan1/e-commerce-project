package com.cengizhan.ecommerceproject.productservice.business.service.impl;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.business.service.IProductService;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductRepository;
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
public class ProductServiceImpl implements IProductService<ProductDto, ProductEntity> {

    private final IProductRepository iProductRepository;
    private final IProductCategoryRepository iProductCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public ProductDto entityToDto(ProductEntity productEntity) {
        return modelMapperBean.modelMapperMethod().map(productEntity,ProductDto.class);
    }

    @Override
    public ProductEntity dtoToEntity(ProductDto productDto) {
        return  modelMapperBean.modelMapperMethod().map(productDto,ProductEntity.class);
    }

    // CREATE
    @Override
    @Transactional // create, delete, update
    public ProductDto productServiceCreate(ProductDto productDto) {
        if (productDto != null) {
            ProductEntity productEntity = dtoToEntity(productDto);
            productEntity.setRelationProductCategoryEntity(iProductCategoryRepository.findById(productDto.getCategoryId()).get());
            iProductRepository.save(productEntity);
            productDto.setId(productEntity.getId());
        } else {
            throw new NullPointerException("ProductDto null veri");
        }
        return productDto;
    }

    // LIST
    @Override
    public List<ProductDto> productServiceListByCategory(Long productCategoryId) {
        List<ProductEntity> entityList = iProductRepository.findByRelationProductCategoryEntityId(productCategoryId);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductEntity entity : entityList) {
            ProductDto productDto = entityToDto(entity);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    // FIND
    @Override
    public ProductDto productServiceFindById(Long id) {
        ProductEntity findProductEntity = null;
        if (id != null) {
            findProductEntity = iProductRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findProductEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public ProductDto productServiceUpdate(Long id, ProductDto productDto) {
        ProductDto productFindDto = productServiceFindById(id);
        if (productFindDto != null) {
            ProductEntity productEntity = dtoToEntity(productFindDto);
            productEntity.setName(productDto.getName());
            productEntity.setDescription_short(productDto.getDescription_short());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setUserId(productDto.getUserId());
            productEntity.setStockState(productDto.getStockState());
            productEntity.setStockCount(productDto.getStockCount());
            productEntity.setCode(productDto.getCode());
            productEntity.setAvgRating(productDto.getAvgRating());
            productEntity.setRelationProductCategoryEntity(iProductCategoryRepository.findById(productDto.getCategoryId()).get());
            iProductRepository.save(productEntity);
            productDto.setId(productEntity.getId());
        }
        return productDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public ProductDto productServiceDeleteById(Long id) {
        ProductDto productFindDto = productServiceFindById(id);
        if (productFindDto != null) {
            iProductRepository.deleteById(id);
        }
        return productFindDto;
    }

    @Override
    @Transactional // create, delete, update
    public ProductDto productServiceDeleteAll() {
        iProductRepository.deleteAll();
        return null;
    }

    @Override
    public List<ProductDto> productServiceListByUserId(Integer userId) {
        List<ProductEntity> entityList = iProductRepository.findByUserId(userId);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductEntity entity : entityList) {
            ProductDto productDto = entityToDto(entity);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
