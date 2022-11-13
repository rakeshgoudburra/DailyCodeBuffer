package com.dailycodebuffer.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;
import com.dailycodebuffer.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@PostMapping("/")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		Long productId=productService.addProduct(productRequest);
		return new ResponseEntity<Long>(productId, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=productService.getProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponce> getProductById(@PathVariable Long productId){
		ProductResponce productResponce=productService.getProductById(productId);
		return new ResponseEntity<>(productResponce,HttpStatus.OK);
	}

}
