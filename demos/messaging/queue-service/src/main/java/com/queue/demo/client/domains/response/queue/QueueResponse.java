
package com.queue.demo.client.domains.response.queue;

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
@JsonPropertyOrder({ "arguments", "auto_delete", "durable", "exclusive", "messages", "messages_details",
		"messages_ready", "messages_ready_details", "messages_unacknowledged", "messages_unacknowledged_details",
		"name", "node", "reductions", "reductions_details", "vhost" })
public class QueueResponse {

	@JsonProperty("arguments")
	private Arguments arguments;

	@JsonProperty("auto_delete")
	private Boolean autoDelete;

	@JsonProperty("durable")
	private Boolean durable;

	@JsonProperty("exclusive")
	private Boolean exclusive;

	@JsonProperty("messages")
	private Integer messages;

	@JsonProperty("messages_details")
	private MessagesDetails messagesDetails;

	@JsonProperty("messages_ready")
	private Integer messagesReady;

	@JsonProperty("messages_ready_details")
	private MessagesReadyDetails messagesReadyDetails;

	@JsonProperty("messages_unacknowledged")
	private Integer messagesUnacknowledged;

	@JsonProperty("messages_unacknowledged_details")
	private MessagesUnacknowledgedDetails messagesUnacknowledgedDetails;

	@JsonProperty("name")
	private String name;

	@JsonProperty("node")
	private String node;

	@JsonProperty("reductions")
	private Integer reductions;

	@JsonProperty("reductions_details")
	private ReductionsDetails reductionsDetails;

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

	@JsonProperty("exclusive")
	public Boolean getExclusive() {
		return exclusive;
	}

	@JsonProperty("exclusive")
	public void setExclusive(Boolean exclusive) {
		this.exclusive = exclusive;
	}

	@JsonProperty("messages")
	public Integer getMessages() {
		return messages;
	}

	@JsonProperty("messages")
	public void setMessages(Integer messages) {
		this.messages = messages;
	}

	@JsonProperty("messages_details")
	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}

	@JsonProperty("messages_details")
	public void setMessagesDetails(MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}

	@JsonProperty("messages_ready")
	public Integer getMessagesReady() {
		return messagesReady;
	}

	@JsonProperty("messages_ready")
	public void setMessagesReady(Integer messagesReady) {
		this.messagesReady = messagesReady;
	}

	@JsonProperty("messages_ready_details")
	public MessagesReadyDetails getMessagesReadyDetails() {
		return messagesReadyDetails;
	}

	@JsonProperty("messages_ready_details")
	public void setMessagesReadyDetails(MessagesReadyDetails messagesReadyDetails) {
		this.messagesReadyDetails = messagesReadyDetails;
	}

	@JsonProperty("messages_unacknowledged")
	public Integer getMessagesUnacknowledged() {
		return messagesUnacknowledged;
	}

	@JsonProperty("messages_unacknowledged")
	public void setMessagesUnacknowledged(Integer messagesUnacknowledged) {
		this.messagesUnacknowledged = messagesUnacknowledged;
	}

	@JsonProperty("messages_unacknowledged_details")
	public MessagesUnacknowledgedDetails getMessagesUnacknowledgedDetails() {
		return messagesUnacknowledgedDetails;
	}

	@JsonProperty("messages_unacknowledged_details")
	public void setMessagesUnacknowledgedDetails(MessagesUnacknowledgedDetails messagesUnacknowledgedDetails) {
		this.messagesUnacknowledgedDetails = messagesUnacknowledgedDetails;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("node")
	public String getNode() {
		return node;
	}

	@JsonProperty("node")
	public void setNode(String node) {
		this.node = node;
	}

	@JsonProperty("reductions")
	public Integer getReductions() {
		return reductions;
	}

	@JsonProperty("reductions")
	public void setReductions(Integer reductions) {
		this.reductions = reductions;
	}

	@JsonProperty("reductions_details")
	public ReductionsDetails getReductionsDetails() {
		return reductionsDetails;
	}

	@JsonProperty("reductions_details")
	public void setReductionsDetails(ReductionsDetails reductionsDetails) {
		this.reductionsDetails = reductionsDetails;
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
