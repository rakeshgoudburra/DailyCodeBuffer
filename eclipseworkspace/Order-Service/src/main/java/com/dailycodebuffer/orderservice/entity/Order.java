package com.dailycodebuffer.orderservice.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ORDER_TABLE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "PRODUCT_ID")
	private long productId;
	@Column(name = "PRODUCT_QUANTITY")
	private long quantity;
	@Column(name = "PRODUCT_DATE")
	private Instant orderDate;
	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	@Column(name = "ORDER_AMOUNT")
	private long amount;

}
