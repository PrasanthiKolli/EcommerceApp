package com.rabbitmq.emailservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.emailservice.dto.OrderEvent;

@Service
public class EmailConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);

	@RabbitListener(queues = "${rabbitmq.queue.order.email.name}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("order mail is received -> %s", event.toString()));
	}

}
