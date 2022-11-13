package com.dailycodebuffer.orderservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.orderservice.model.OrderRequest;
import com.dailycodebuffer.orderservice.model.OrderResponce;
import com.dailycodebuffer.orderservice.repository.OrderRepository;
import com.dailycodebuffer.orderservice.entity.Order;
import com.dailycodebuffer.orderservice.exception.CustomException;
import com.dailycodebuffer.orderservice.external.client.PaymentService;
import com.dailycodebuffer.orderservice.external.client.ProductService;
import com.dailycodebuffer.orderservice.external.client.request.PaymentRequest;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private PaymentService paymentService;

	@Override
	public long placeOrder(OrderRequest orderRequest) {
		log.info("placing order request : {}", orderRequest);
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("Creating order with status created");
		Order order = Order.builder().amount(orderRequest.getTotalAmount()).orderStatus("CREATED")
				.orderDate(Instant.now()).quantity(orderRequest.getQuantity()).productId(orderRequest.getProductId())
				.build();
		orderRepository.save(order);
		log.info("Order placed succesfully with orderId :{}", order.getId());
		log.info("Calling the payment service to complete tyhe payment");
		PaymentRequest paymentRequest = PaymentRequest.builder().orderId(order.getId()).
		amount(orderRequest.getTotalAmount()).
		paymentMode(orderRequest.getPaymantMode()).build();
		
		String orderStatus=null;
		try {
			paymentService.doPayment(paymentRequest);
		log.info("Payment done successfully, changing the order status to order PLACED");
		orderStatus="PLACED";
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ERROR OCCURED IN THE PAYMENT. CHANGING THE ORDER STATUS TO FAILED");
		orderStatus="FAILED";
		}
		order.setOrderStatus(orderStatus);
		orderRepository.save(order);
		return order.getId();
	}

	@Override
	public OrderResponce getOrderDetails(long orderId) {
		// TODO Auto-generated method stub
		log.info("GET THE ORDER DETAILS BY ORDER ID: {}",orderId);
		Order order = orderRepository.findById(orderId).
		orElseThrow(()->new CustomException("Order Not found with OrderId "+orderId, "Order_NOT_FOUNT", 404));
		
		OrderResponce orderResponce = OrderResponce.builder().OrderId(order.getId()).orderDate(Instant.now()).OrderStatus(order.getOrderStatus())
		.amount(order.getAmount()).build();
		
		return orderResponce;
	}

}
