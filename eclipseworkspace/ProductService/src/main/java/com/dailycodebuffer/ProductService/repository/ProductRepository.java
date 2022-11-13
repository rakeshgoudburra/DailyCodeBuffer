package com.dailycodebuffer.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.ProductService.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
