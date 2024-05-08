package com.rabbirmq.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {
	
	private static Logger LOGGER=LoggerFactory.getLogger(RabbitMqConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message) {
		LOGGER.info(String.format("Received message from queue -> %s", message));
	}

}