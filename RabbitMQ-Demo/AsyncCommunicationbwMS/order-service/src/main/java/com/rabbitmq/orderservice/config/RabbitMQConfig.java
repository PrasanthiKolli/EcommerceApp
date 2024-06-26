package com.rabbitmq.orderservice.config;

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
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.order.stock.name}")
	private String stockQueue;

	@Value("${rabbitmq.exchange.order.name}")
	private String exchange;

	@Value("${rabbitmq.order.stock.routing.key}")
	private String stockRoutingKey;
	
	@Value("${rabbitmq.queue.order.email.name}")
	private String emailQueue;

	@Value("${rabbitmq.order.email.routing.key}")
	private String emailRoutingKey;

	@Bean
	public Queue stockQueue() {
		return new Queue(stockQueue);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Queue emailQueue() {
		return new Queue(emailQueue);
	}

	@Bean
	public Binding orderStockBinding() {
		return BindingBuilder.bind(stockQueue()).to(exchange()).with(stockRoutingKey);
	}
	
	@Bean
	public Binding orderEmailBinding() {
		return BindingBuilder.bind(emailQueue()).to(exchange()).with(emailRoutingKey);
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
