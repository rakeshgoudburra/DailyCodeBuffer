package com.dailycodebuffer.paymentservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.paymentservice.entity.TransactionDetails;
import com.dailycodebuffer.paymentservice.model.PaymentMode;
import com.dailycodebuffer.paymentservice.model.PaymentRequest;
import com.dailycodebuffer.paymentservice.repository.PaymentRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository PaymentRepository;

	@Override
	public Long doPayment(PaymentRequest paymentRequest) {
		log.info("recording the payment details :{}",paymentRequest);
		// TODO Auto-generated method stub
		TransactionDetails transactionDetails = TransactionDetails.builder().paymentDate(Instant.now())
		.amount(paymentRequest.getAmount()).
		orderId(paymentRequest.getOrderId()).
		referenceNumber(paymentRequest.getReferenceNumber()).
		paymentMode(paymentRequest.getPaymentMode().name()).build();
		 PaymentRepository.save(transactionDetails);
		 log.info("Transaction successfull with Id : {} ",transactionDetails.getId());
		return transactionDetails.getId();
	}

}
