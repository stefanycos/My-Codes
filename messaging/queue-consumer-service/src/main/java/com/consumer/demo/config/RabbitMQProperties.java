package com.consumer.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("spring.jms.rabbitmq")
public class RabbitMQProperties {

	private String queue;
	
	private String exchange;
	
	private String exchangeType;
	
	private String binding;
}
