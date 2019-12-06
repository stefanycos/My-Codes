package com.consumer.demo.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConnectionFactoryConfig {

	@Autowired
	private SpringRabbitMQProperties properties; 
	
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(properties.getHost());
		connectionFactory.setUsername(properties.getUsername());
		connectionFactory.setPassword(properties.getPassword());
		connectionFactory.setVirtualHost(properties.getVirtualHost());
		connectionFactory.setPort(Integer.valueOf(properties.getPort()));
		
		return connectionFactory;
	}
}
