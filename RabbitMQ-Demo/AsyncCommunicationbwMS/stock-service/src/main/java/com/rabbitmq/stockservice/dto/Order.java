package com.rabbitmq.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {
	
	private String orderId;
	
	private String name;
	
	private int qty;
	
	private double price;
	

}
