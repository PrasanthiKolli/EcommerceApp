package com.rabbitmq.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.orderservice.dto.Order;
import com.rabbitmq.orderservice.publisher.OrderProducer;

@RestController
@RequestMapping("api/v1")
public class OrderController {
	
	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		
		return null;
		
	}

}
