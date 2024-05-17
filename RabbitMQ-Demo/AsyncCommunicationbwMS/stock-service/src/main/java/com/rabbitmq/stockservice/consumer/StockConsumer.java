package com.rabbitmq.stockservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbitmq.stockservice.dto.OrderEvent;

@Service
public class StockConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(StockConsumer.class);
	
	@RabbitListener(queues = "${rabbitmq.queue.order.stock.name}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("order is received -> %s", event.toString()));
		
	}
}
