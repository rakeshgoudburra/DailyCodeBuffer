package com.dailycodebuffer.paymentservice.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_DETAILS")

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDetails {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAYMENT_ID")
	private long Id;
	@Column(name = "ORDER_ID")
	private long orderId;
	@Column(name = "MODE")
	private String paymentMode;
	@Column(name = "REFERENCE_NUMBER")
	private String referenceNumber;
	@Column(name = "STATUS")
	private String paymentStatus;
	@Column(name = "DATE")
	private Instant paymentDate;
	@Column(name = "AMOUNT")
	private long amount;

}
