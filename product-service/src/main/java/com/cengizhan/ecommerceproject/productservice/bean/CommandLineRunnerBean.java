package com.cengizhan.ecommerceproject.productservice.bean;

import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.entity.Product;
import com.cengizhan.ecommerceproject.productservice.entity.Review;
import com.cengizhan.ecommerceproject.productservice.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.repository.IReviewRepository;
import com.cengizhan.ecommerceproject.productservice.entity.enums.StockState;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Lombok
@RequiredArgsConstructor

@Configuration
@Log4j2
@Component
public class CommandLineRunnerBean {
    // Injection
    private final IProductRepository iProductRepository;
    private final IProductCategoryRepository iProductCategoryRepository;
    private final IReviewRepository iReviewRepository;

    public void dummyTask() {
        for (int i = 0; i < 5; i++) {
            ProductCategory ProductCategory = new ProductCategory();
            ProductCategory.setName("Category " + i);
            ProductCategory.setDescription("Description " + i);
            iProductCategoryRepository.save(ProductCategory);

            Product product = new Product();
            product.setName("Product " + i);
            product.setDescription("Description " + i);
            product.setPrice((float) i);
            product.setStockState(StockState.LOW);
            product.setStockCount(i);
            product.setCode("Code " + i);
            product.setAvgRating((float) i);
            product.setRelationProductCategory(ProductCategory);
            iProductRepository.save(product);

            Review review = new Review();
            review.setReview("Review " + i);
            review.setRating(i);
            review.setRelationProduct(product);
            iReviewRepository.save(review);
        }
    }


    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod() {
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");
            if (iProductRepository.count() == 0) {
//                dummyTask();
            }
        };
    }
}