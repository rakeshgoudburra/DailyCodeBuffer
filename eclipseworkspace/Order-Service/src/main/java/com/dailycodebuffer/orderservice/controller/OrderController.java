package com.dailycodebuffer.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.orderservice.model.OrderRequest;
import com.dailycodebuffer.orderservice.model.OrderResponce;
import com.dailycodebuffer.orderservice.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeorder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
		long orderId=orderService.placeOrder(orderRequest);
		log.info("order id: {}",orderId);
		return new ResponseEntity<Long>(orderId,HttpStatus.OK);
	}
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponce> getOrderDeatails(@PathVariable long orderId){
		OrderResponce orderResponce=orderService.getOrderDetails(orderId);
		return new ResponseEntity<OrderResponce>(orderResponce, HttpStatus.OK);
		
	}

}
