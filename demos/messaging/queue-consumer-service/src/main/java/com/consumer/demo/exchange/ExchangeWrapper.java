package com.consumer.demo.exchange;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consumer.demo.config.RabbitMQProperties;

@Component
public class ExchangeWrapper {

	private static final String TOPIC = "topic";
	private static final String FANOUT = "fanout";
	private static final String DIRECT = "direct";
	private static final String HEADERS = "headers";

	@Autowired
	private RabbitMQProperties properties;

	public Exchange createExchange(){

		switch (properties.getExchangeType()) {
		case TOPIC:
			return ExchangeBuilder
					.topicExchange(properties.getExchange())
					.build();
		case FANOUT:
			return ExchangeBuilder
					.fanoutExchange(properties.getExchange())
					.build();
		case DIRECT:
			return createDirectExchange();
			
		case HEADERS:
			return ExchangeBuilder
					.headersExchange(properties.getExchange())
					.build();
		default:
			return createDirectExchange();
		}
	}
	
	private Exchange createDirectExchange() {
		return ExchangeBuilder
				.directExchange(properties.getExchange())
				.build();
	}
}
