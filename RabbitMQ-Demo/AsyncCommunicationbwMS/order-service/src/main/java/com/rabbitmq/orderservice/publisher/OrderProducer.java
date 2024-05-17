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

	@Value("${rabbitmq.order.stock.routing.key}")
	private String stockRoutingKey;

	@Value("${rabbitmq.order.email.routing.key}")
	private String emailRoutingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemaplte;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderProducer.class);
	
	public void sendMessageToStock(OrderEvent orderEvent) {
		LOGGER.info(String.format("order sent to stock -> %s",orderEvent.toString()));
		rabbitTemaplte.convertAndSend(exchange, stockRoutingKey, orderEvent);
	}
	
	public void sendMessageToEmail(OrderEvent orderEvent) {
		LOGGER.info(String.format("order sent to email -> %s",orderEvent.toString()));
		rabbitTemaplte.convertAndSend(exchange, emailRoutingKey, orderEvent);
	}

}
