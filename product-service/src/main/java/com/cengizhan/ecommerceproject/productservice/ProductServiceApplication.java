package com.cengizhan.ecommerceproject.productservice;

import com.cengizhan.ecommerceproject.productservice.data.entity.Product;
import com.cengizhan.ecommerceproject.productservice.data.entity.ProductCategory;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductCategoryRepository;
import com.cengizhan.ecommerceproject.productservice.data.repository.IProductRepository;
import com.cengizhan.ecommerceproject.productservice.enums.StockState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private final IProductRepository iProductRepository;
	private final IProductCategoryRepository productCategoryRepository;

	public ProductServiceApplication(IProductRepository iProductRepository, IProductCategoryRepository productCategoryRepository) {
		this.iProductRepository = iProductRepository;
		this.productCategoryRepository = productCategoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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

		iProductRepository.saveAll(List.of(product1, product2));
	}
}
