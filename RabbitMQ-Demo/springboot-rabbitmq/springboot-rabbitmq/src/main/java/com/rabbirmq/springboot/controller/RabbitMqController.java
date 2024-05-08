package com.rabbirmq.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbirmq.springboot.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {

	@Autowired
	private RabbitMqProducer rabbitMqProducer;

	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

		rabbitMqProducer.sendMessage(message);

		return ResponseEntity.ok("Message sent to rabbitMq");
	}

}
