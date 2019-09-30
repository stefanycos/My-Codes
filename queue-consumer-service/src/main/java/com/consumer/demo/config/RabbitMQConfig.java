package com.consumer.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.consumer.demo.exchange.ExchangeWrapper;
import com.consumer.demo.listener.RabbitMQMessageListener;

@Configuration
public class RabbitMQConfig {
	
	@Autowired
	private RabbitMQProperties properties;
	
	@Autowired
	private ConnectionFactoryConfig connectionFactory;
	
	@Autowired
	private ExchangeWrapper exchangeWapper;

	@Bean
	Queue queue() {
		return new Queue(properties.getQueue());
	}
	
	@Bean
	Exchange exchange() {
		return exchangeWapper.createExchange();
	}
	
	@Bean
	Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(properties.getBinding())
				.noargs();
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory.connectionFactory());
		container.setQueues(queue());
		container.setMessageListener(new RabbitMQMessageListener());
		
		return container;

	}
}
