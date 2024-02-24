package com.cengizhan.ecommerceproject.productservice.business.service;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.data.entity.Product;
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
public class ProductService {

    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    
    public ProductDto entityToDto(Product product) {
        return modelMapperBean.modelMapperMethod().map(product,ProductDto.class);
    }

    
    public Product dtoToEntity(ProductDto productDto) {
        return  modelMapperBean.modelMapperMethod().map(productDto, Product.class);
    }

    // LIST
    public List<ProductDto> list() {
        List<Product> entityList = (List<Product>) iProductRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product entity : entityList) {
            ProductDto productDto = entityToDto(entity);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }


    // LIST BY CATEGORY
    public List<ProductDto> listByCategory(Long productCategoryId) {
        List<Product> entityList = iProductRepository.findByRelationProductCategoryId(productCategoryId);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product entity : entityList) {
            ProductDto productDto = entityToDto(entity);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

//    // LIST BY USER ID
//    public List<ProductDto> listByUserId(Integer userId) {
//        List<Product> entityList = iProductRepository.findByUserId(userId);
//        List<ProductDto> productDtoList = new ArrayList<>();
//        for (Product entity : entityList) {
//            ProductDto productDto = entityToDto(entity);
//            productDtoList.add(productDto);
//        }
//        return productDtoList;
//    }

    // FIND
    public ProductDto findById(Long id) {
        Product findProduct = null;
        if (id != null) {
            findProduct = iProductRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id yoktur"));
        } else {
            throw new CustomException("İd null olarak geldi");
        }
        return entityToDto(findProduct);
    }
    

}
