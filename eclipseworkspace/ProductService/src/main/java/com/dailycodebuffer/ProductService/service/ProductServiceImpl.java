package com.dailycodebuffer.ProductService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.exception.ProductServiceCustomException;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;
import com.dailycodebuffer.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addProduct(ProductRequest productRequest) {
		log.info("	ADDING THE PRODUCT......");
		Product product = Product.builder().productName(productRequest.getName()).price(productRequest.getPrice())
				.quantity(productRequest.getQuantity()).build();
		productRepository.save(product);
		log.info("PRODUCT CREATED");
		return product.getProductId();
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> findAll = productRepository.findAll();
		return findAll;
	}

	@Override
	public ProductResponce getProductById(Long ProductId) {
		// TODO Auto-generated method stub
		log.info("retriving the product by productId: {}", ProductId);
		Product product = productRepository.findById(ProductId)
				.orElseThrow(() -> new ProductServiceCustomException("Product with given Id is not found in Database","PRODUCT_NOT_FOUND"));

		ProductResponce productResponce = ProductResponce.builder().ProductId(product.getProductId())
				.productName(product.getProductName()).price(product.getPrice()).quantity(product.getQuantity())
				.build();

		return productResponce;
	}

}
