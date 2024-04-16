package com.cengizhan.ecommerceproject.productservice;

import com.cengizhan.ecommerceproject.productservice.client.RetreiveMessageErrorDecoder;
import com.cengizhan.ecommerceproject.productservice.entity.Product;
import com.cengizhan.ecommerceproject.productservice.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.entity.enums.StockState;
import feign.codec.ErrorDecoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProductServiceApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new RetreiveMessageErrorDecoder();
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
