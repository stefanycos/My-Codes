package com.queue.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.queue.demo.config.feign.FeignErrorDecoder;

@SpringBootApplication
@EnableFeignClients
public class QueueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueServiceApplication.class, args);
	}

	@Bean
	public FeignErrorDecoder errorDecoder() {
		return new FeignErrorDecoder();
	}

}
