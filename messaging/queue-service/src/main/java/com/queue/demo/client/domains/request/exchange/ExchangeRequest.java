
package com.queue.demo.client.domains.request.exchange;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.queue.demo.client.domains.Arguments;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "arguments", "auto_delete", "durable", "internal", "name", "type", "user_who_performed_action",
		"vhost" })
public class ExchangeRequest {

	@JsonProperty("arguments")
	private Arguments arguments;
	
	@JsonProperty("auto_delete")
	private Boolean autoDelete;
	
	@JsonProperty("durable")
	private Boolean durable;
	
	@JsonProperty("internal")
	private Boolean internal;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	@NotEmpty(message = "Field type can't be empty")
	@NotNull(message = "Field type can't be null")
	private String type;
	
	@JsonProperty("user_who_performed_action")
	private String userWhoPerformedAction;
	
	@JsonProperty("vhost")
	private String vhost;
	
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

	@JsonProperty("internal")
	public Boolean getInternal() {
		return internal;
	}

	@JsonProperty("internal")
	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("user_who_performed_action")
	public String getUserWhoPerformedAction() {
		return userWhoPerformedAction;
	}

	@JsonProperty("user_who_performed_action")
	public void setUserWhoPerformedAction(String userWhoPerformedAction) {
		this.userWhoPerformedAction = userWhoPerformedAction;
	}

	@JsonProperty("vhost")
	public String getVhost() {
		return vhost;
	}

	@JsonProperty("vhost")
	public void setVhost(String vhost) {
		this.vhost = vhost;
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
