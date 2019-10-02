
package com.queue.demo.client.domains.response.host;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cluster_state", "name", "recv_oct", "recv_oct_details", "send_oct", "send_oct_details",
		"tracing" })
public class HostsResponse {

	@JsonProperty("cluster_state")
	private ClusterState clusterState;

	@JsonProperty("name")
	private String name;

	@JsonProperty("recv_oct")
	private Integer recvOct;

	@JsonProperty("recv_oct_details")
	private RecvOctDetails recvOctDetails;

	@JsonProperty("send_oct")
	private Integer sendOct;

	@JsonProperty("send_oct_details")
	private SendOctDetails sendOctDetails;

	@JsonProperty("tracing")
	private Boolean tracing;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("cluster_state")
	public ClusterState getClusterState() {
		return clusterState;
	}

	@JsonProperty("cluster_state")
	public void setClusterState(ClusterState clusterState) {
		this.clusterState = clusterState;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("recv_oct")
	public Integer getRecvOct() {
		return recvOct;
	}

	@JsonProperty("recv_oct")
	public void setRecvOct(Integer recvOct) {
		this.recvOct = recvOct;
	}

	@JsonProperty("recv_oct_details")
	public RecvOctDetails getRecvOctDetails() {
		return recvOctDetails;
	}

	@JsonProperty("recv_oct_details")
	public void setRecvOctDetails(RecvOctDetails recvOctDetails) {
		this.recvOctDetails = recvOctDetails;
	}

	@JsonProperty("send_oct")
	public Integer getSendOct() {
		return sendOct;
	}

	@JsonProperty("send_oct")
	public void setSendOct(Integer sendOct) {
		this.sendOct = sendOct;
	}

	@JsonProperty("send_oct_details")
	public SendOctDetails getSendOctDetails() {
		return sendOctDetails;
	}

	@JsonProperty("send_oct_details")
	public void setSendOctDetails(SendOctDetails sendOctDetails) {
		this.sendOctDetails = sendOctDetails;
	}

	@JsonProperty("tracing")
	public Boolean getTracing() {
		return tracing;
	}

	@JsonProperty("tracing")
	public void setTracing(Boolean tracing) {
		this.tracing = tracing;
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
