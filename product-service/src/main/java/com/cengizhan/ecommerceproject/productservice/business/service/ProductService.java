package com.cengizhan.ecommerceproject.productservice.business.service;

import com.cengizhan.ecommerceproject.productservice.bean.ModelMapperBean;
import com.cengizhan.ecommerceproject.productservice.business.dto.BasketItemDto;
import com.cengizhan.ecommerceproject.productservice.client.BasketClient;
import com.cengizhan.ecommerceproject.productservice.data.entity.Product;
import com.cengizhan.ecommerceproject.productservice.business.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;
    private final BasketClient basketClient;

    public ProductService(IProductRepository iProductRepository,
                          ModelMapperBean modelMapperBean,
                          BasketClient basketClient) {
        this.iProductRepository = iProductRepository;
        this.modelMapperBean = modelMapperBean;
        this.basketClient = basketClient;
    }

    // MODEL MAPPER

    public ProductDto entityToDto(Product product) {
        return modelMapperBean.modelMapperMethod().map(product, ProductDto.class);
    }


    public Product dtoToEntity(ProductDto productDto) {
        return modelMapperBean.modelMapperMethod().map(productDto, Product.class);
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
        Product findProduct = iProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
        return entityToDto(findProduct);
    }


    public void addBasket(Long id, short quantity) {
        basketClient.addProductToBasket(1, new BasketItemDto(id, quantity));
    }

    public void removeBasket(Long id) {
        basketClient.removeProductFromBasket(1, id);
    }

    public void clearBasket() {
        basketClient.clearBasket(1);
    }

    public List<ProductDto> getBasket() {
        basketClient.listProductsInBasket(1);
        return null;
    }
}
