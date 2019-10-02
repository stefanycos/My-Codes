package com.queue.demo.publisher.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RequestBodyDTO {

	@NotEmpty(message = "payload can't be empty")
	@NotNull(message = "payload can't be null")
	private String payload;
	
	@NotEmpty(message = "routingKey can't be empty")
	@NotNull(message = "routingKey can't be null")
	private String routingKey;
	
	@NotEmpty(message = "exchange can't be empty")
	@NotNull(message = "exchange can't be null")
	private String exchange;
}
