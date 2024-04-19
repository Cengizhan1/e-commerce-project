package com.cengizhan.ecommerceproject.productservice.service;

import com.cengizhan.ecommerceproject.productservice.dto.BasketItemDto;
import com.cengizhan.ecommerceproject.productservice.client.BasketClient;
import com.cengizhan.ecommerceproject.productservice.entity.Product;
import com.cengizhan.ecommerceproject.productservice.dto.ProductDto;
import com.cengizhan.ecommerceproject.productservice.repository.ProductRepository;
import com.cengizhan.ecommerceproject.productservice.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final BasketClient basketClient;

    public ProductService(ProductRepository productRepository,
                          BasketClient basketClient) {
        this.productRepository = productRepository;
        this.basketClient = basketClient;
    }

    public List<ProductDto> list() {
        return productRepository.findAll().stream().map(ProductDto::convert).toList();
    }

    public List<ProductDto> listByCategory(Long productCategoryId) {
        return productRepository.findByRelationProductCategoryId(productCategoryId)
                .stream()
                .map(ProductDto::convert)
                .toList();
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
        return ProductDto.convert(findProduct(id));
    }


    public void addBasket(Long id, Short quantity, String bearerToken) {
        basketClient.addProductToBasket(1,
                new BasketItemDto(id,
                        quantity),
                bearerToken);
    }

    public void removeBasket(Long id, String bearerToken) {
        basketClient.removeProductFromBasket(1, id, bearerToken);
    }

    public void clearBasket(String bearerToken) {
        basketClient.clearBasket(1, bearerToken);
    }

    public List<ProductDto> getBasket(String bearerToken) {
        basketClient.listProductsInBasket(1, bearerToken);
        return null;
    }

    protected Product findProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));
    }
}
