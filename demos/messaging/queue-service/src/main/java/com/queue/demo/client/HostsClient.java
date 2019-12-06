package com.queue.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.queue.demo.client.domains.request.host.HostRequest;
import com.queue.demo.client.domains.response.host.HostsResponse;
import com.queue.demo.config.feign.FeignClientConfiguration;

@FeignClient(name = "vhosts-client", url = "${rabbitmq.baseUrl}", path = "/vhosts", configuration = FeignClientConfiguration.class)
public interface HostsClient {

	@GetMapping
	HostsResponse[] getHosts();

	@PutMapping("/{name}")
	void create(@PathVariable("name") String name, @RequestBody HostRequest body);

	@DeleteMapping("/{name}")
	void delete(@PathVariable("name") String name);

}
