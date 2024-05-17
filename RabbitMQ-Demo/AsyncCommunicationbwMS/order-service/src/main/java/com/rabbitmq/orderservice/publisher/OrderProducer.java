package com.rabbitmq.orderservice.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.orderservice.dto.OrderEvent;

@Service
public class OrderProducer {
	
	@Value("${rabbitmq.exchange.order.name}")
	private String exchange;

	@Value("${rabbitmq.order.routing.key}")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemaplte;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderProducer.class);
	
	public void sendMessage(OrderEvent orderEvent) {
		LOGGER.info("order is intiated");
		rabbitTemaplte.convertAndSend(exchange, routingKey, orderEvent);
	}

}
