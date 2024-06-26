package com.rabbirmq.springboot.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Value("${rabbitmq.json.queue.name}")
	private String jsonQueue;

	@Value("${rabbitmq.json.routing.key}")
	private String jsonRoutingKey;

	@Bean
	public Queue queue() {
		return new Queue(queue);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}

	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}

	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue()).to(exchange()).with(jsonRoutingKey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {

		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
