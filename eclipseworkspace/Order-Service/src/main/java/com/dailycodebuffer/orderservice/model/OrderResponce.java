package com.dailycodebuffer.orderservice.model;

import java.time.Instant;

import lombok.*;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponce {
 private long OrderId;
 private Instant orderDate;
 private String OrderStatus;
 private long amount;
 
}
