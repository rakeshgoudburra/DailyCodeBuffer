package com.dailycodebuffer.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.paymentservice.entity.TransactionDetails;

public interface PaymentRepository extends JpaRepository<TransactionDetails, Long> {

}
