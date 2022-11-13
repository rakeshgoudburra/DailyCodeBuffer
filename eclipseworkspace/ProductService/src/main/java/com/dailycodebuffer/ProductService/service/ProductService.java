package com.dailycodebuffer.ProductService.service;

import java.util.List;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	List<Product> getProducts();
	
	ProductResponce getProductById(Long ProductId);

}
