package com.dailycodebuffer.orderservice.external.client.request;

import com.dailycodebuffer.orderservice.model.PaymantMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
 private long orderId;
 private long amount;
 private String referenceNumber;
 private PaymantMode paymentMode;
}
