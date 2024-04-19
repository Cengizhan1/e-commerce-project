package com.cengizhan.ecommerceproject.productservice.bean;

import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.entity.Product;
import com.cengizhan.ecommerceproject.productservice.repository.ProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.repository.ProductRepository;
import com.cengizhan.ecommerceproject.productservice.entity.enums.StockState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Configuration
@Component
public class CommandLineRunnerBean {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final Logger log = Logger.getLogger(CommandLineRunnerBean.class.getName());

    public CommandLineRunnerBean(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public void dummyData() {
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setName("Elektronik");
        productCategory1.setDescription_short("Elektronik ürünler");
        productCategory1.setDescription("Elektronik ürünler hakkında bilgi");

        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setName("Bilgisayar");
        productCategory2.setDescription_short("Bilgisayar ürünler");
        productCategory2.setDescription("Bilgisayar ürünler hakkında bilgi");
        productCategoryRepository.saveAll(List.of(productCategory1, productCategory2));

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setRelationProductCategory(productCategory2);
        product1.setDescription_short("Laptop bilgisayar");
        product1.setDescription("Laptop bilgisayar");
        product1.setCode("LAPTOP");
        product1.setPrice(1000f);
        product1.setStockState(StockState.MEDIUM);
        product1.setStockCount(100);

        Product product2 = new Product();
        product2.setName("Masaüstü");
        product2.setRelationProductCategory(productCategory2);
        product2.setDescription_short("Masaüstü bilgisayar");
        product2.setDescription("Masaüstü bilgisayar");
        product2.setCode("PC");
        product2.setPrice(2000f);
        product2.setStockState(StockState.MEDIUM);
        product2.setStockCount(100);

        productRepository.saveAll(List.of(product1, product2));
    }


    @Bean
    public CommandLineRunner createDummyData() {
        return args -> {
            log.info("CommandLineRunner is running");
            if (productRepository.count() == 0) {
                dummyData();
            }
        };
    }
}