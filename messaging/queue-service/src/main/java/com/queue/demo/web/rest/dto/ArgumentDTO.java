package com.queue.demo.web.rest.dto;

import com.queue.demo.client.domains.Arguments;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArgumentDTO {

	private String alternateExhange;

	public static ArgumentDTO converter(Arguments arguments) {
		return ArgumentDTO.builder()
				.alternateExhange(arguments.getAlternateExchange())
				.build();
	}
}
