package com.rabbirmq.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbirmq.springboot.dto.User;

@Service
public class RabbitMqJsonProducer {

	@Autowired
	private RabbitTemplate restTemplate;

	@Value("${rabbitmq.json.routing.key}")
	private String jsonRoutingKey;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("Json message sent -> %s", user));
		restTemplate.convertAndSend(exchange, jsonRoutingKey, user);

	}

}
