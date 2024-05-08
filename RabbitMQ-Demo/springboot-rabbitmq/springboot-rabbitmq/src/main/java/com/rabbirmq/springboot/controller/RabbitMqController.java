package com.rabbirmq.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbirmq.springboot.dto.User;
import com.rabbirmq.springboot.publisher.RabbitMqJsonProducer;
import com.rabbirmq.springboot.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {

	@Autowired
	private RabbitMqProducer rabbitMqProducer;
	
	@Autowired
	private RabbitMqJsonProducer rabbitMqJsonProducer;

	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {

		rabbitMqProducer.sendMessage(message);

		return ResponseEntity.ok("Message sent to rabbitMq");
	}
	
	@PostMapping("/publish/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody  User user) {

		rabbitMqJsonProducer.sendJsonMessage(user);

		return ResponseEntity.ok("Json Message sent to rabbitMq");
	}


}
