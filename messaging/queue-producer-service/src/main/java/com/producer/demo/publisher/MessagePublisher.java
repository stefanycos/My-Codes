package com.producer.demo.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.producer.demo.publisher.dto.RequestBodyDTO;

@Component
public class MessagePublisher {

	@Autowired
	private RabbitTemplate template;
	
	public void sendMessage(RequestBodyDTO request) {
		
		template.convertAndSend(request.getExchange(), request.getRoutingKey(), request.getPayload());
	}
}
