package com.queue.demo.client.domains.request.exchange;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeMessageRequest {

	private Map<String, Object> properties = new HashMap<>();

	@NotEmpty(message = "Field type can't be empty")
	@NotNull(message = "Field type can't be null")
	@JsonProperty("routing_key")
	private String routingKey;

	@NotEmpty(message = "Field type can't be empty")
	@NotNull(message = "Field type can't be null")
	private String payload;

	@NotEmpty(message = "Field type can't be empty")
	@NotNull(message = "Field type can't be null")
	@JsonProperty("payload_encoding")
	private String payloadEncoding;

	@JsonAnyGetter
	public Map<String, Object> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPayloadEncoding() {
		return payloadEncoding;
	}

	public void setPayloadEncoding(String payloadEncoding) {
		this.payloadEncoding = payloadEncoding;
	}

}
