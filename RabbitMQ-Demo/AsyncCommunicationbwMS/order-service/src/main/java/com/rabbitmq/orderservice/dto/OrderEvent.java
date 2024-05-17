package com.rabbitmq.orderservice.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent implements Serializable{
	
	private String status;
	
	private String message;
	
	private Order order;

}
