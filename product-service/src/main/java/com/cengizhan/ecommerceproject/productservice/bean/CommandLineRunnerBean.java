package com.cengizhan.ecommerceproject.productservice.bean;

import com.cengizhan.ecommerceproject.productservice.data.entity.ProductCategoryEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductEntity;
import com.cengizhan.ecommerceproject.productservice.data.entity.ReviewEntity;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.data.repository.IReviewRepository;
import com.cengizhan.ecommerceproject.productservice.enums.StockState;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

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
            ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
            productCategoryEntity.setName("Category " + i);
            productCategoryEntity.setDescription("Description " + i);
            iProductCategoryRepository.save(productCategoryEntity);

            ProductEntity productEntity = new ProductEntity();
            productEntity.setName("Product " + i);
            productEntity.setDescription("Description " + i);
            productEntity.setPrice((float) i);
            productEntity.setStockState(StockState.LOW);
            productEntity.setStockCount(i);
            productEntity.setCode("Code " + i);
            productEntity.setAvgRating((float) i);
            productEntity.setRelationProductCategoryEntity(productCategoryEntity);
            iProductRepository.save(productEntity);

            ReviewEntity reviewEntity = new ReviewEntity();
            reviewEntity.setReview("Review " + i);
            reviewEntity.setRating(i);
            reviewEntity.setRelationProductEntity(productEntity);
            iReviewRepository.save(reviewEntity);
        }
    }


    @Bean
    public CommandLineRunner blogCommandLineRunnerMethod() {
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");
            if (iProductRepository.count() == 0) {
                dummyTask();
            }
        };
    }
}