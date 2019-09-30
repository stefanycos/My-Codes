package com.consumer.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("spring.rabbitmq")
public class SpringRabbitMQProperties {

	private String host;

	private String port;

	private String username;

	private String password;

	private String virtualHost;

}
