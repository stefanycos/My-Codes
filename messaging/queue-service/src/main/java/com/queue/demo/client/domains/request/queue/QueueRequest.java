
package com.queue.demo.client.domains.request.queue;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.queue.demo.client.domains.Arguments;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "arguments", "auto_delete", "durable", "node" })
public class QueueRequest {

	@JsonProperty("arguments")
	private Arguments arguments;

	@JsonProperty("auto_delete")
	private Boolean autoDelete;

	@JsonProperty("durable")
	private Boolean durable;

	@JsonProperty("node")
	private String node;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("arguments")
	public Arguments getArguments() {
		return arguments;
	}

	@JsonProperty("arguments")
	public void setArguments(Arguments arguments) {
		this.arguments = arguments;
	}

	@JsonProperty("auto_delete")
	public Boolean getAutoDelete() {
		return autoDelete;
	}

	@JsonProperty("auto_delete")
	public void setAutoDelete(Boolean autoDelete) {
		this.autoDelete = autoDelete;
	}

	@JsonProperty("durable")
	public Boolean getDurable() {
		return durable;
	}

	@JsonProperty("durable")
	public void setDurable(Boolean durable) {
		this.durable = durable;
	}

	@JsonProperty("node")
	public String getNode() {
		return node;
	}

	@JsonProperty("node")
	public void setNode(String node) {
		this.node = node;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
