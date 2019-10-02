package com.queue.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.queue.demo.client.domains.response.exhange.ExchangeResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDTO {

	@JsonProperty("arguments")
	private ArgumentDTO argumentDTO;

	private Boolean autoDelete;

	private Boolean durable;

	private Boolean internal;

	private String name;

	private String type;

	public static ExchangeDTO[] conveter(ExchangeResponse[] exchangeResponses) {
		ExchangeDTO[] reponse = new ExchangeDTO[exchangeResponses.length];

		for (int i = 0; i < exchangeResponses.length; i++) {
			reponse[i] = ExchangeDTO.builder()
					.argumentDTO(ArgumentDTO.converter(exchangeResponses[i].getArguments()))
					.autoDelete(exchangeResponses[i]
					.getAutoDelete())
					.durable(exchangeResponses[i].getDurable())
					.internal(exchangeResponses[i].getInternal())
					.name(exchangeResponses[i].getName())
					.type(exchangeResponses[i].getType())
					.build();
		}

		return reponse;
	}
}
