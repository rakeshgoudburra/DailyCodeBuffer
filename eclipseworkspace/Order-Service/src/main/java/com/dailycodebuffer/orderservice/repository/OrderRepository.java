package com.dailycodebuffer.orderservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<com.dailycodebuffer.orderservice.entity.Order, Long> {

}
