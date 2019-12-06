package com.queue.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.queue.demo.client.domains.request.exchange.ExchangeMessageRequest;
import com.queue.demo.client.domains.request.exchange.ExchangeRequest;
import com.queue.demo.client.domains.response.exhange.ExchangeResponse;
import com.queue.demo.config.feign.FeignClientConfiguration;

@FeignClient(name = "exchange-client", url = "${rabbitmq.baseUrl}", path = "/exchanges", configuration = FeignClientConfiguration.class)
public interface ExchangeClient {

	@GetMapping
	ExchangeResponse[] getExchanges();

	@PutMapping("/{vhost}/{name}")
	void create(@PathVariable("vhost") String vhost, @PathVariable("name") String name, @RequestBody ExchangeRequest body);
	
	
	@DeleteMapping("/{vhost}/{name}")
	void delete(@PathVariable("vhost") String vhost, @PathVariable("name") String name, @RequestParam(name = "if-unused") Boolean ifUnused);

	
	@PostMapping("/{vhost}/{name}/publish")
	void publish(@PathVariable("vhost") String vhost, @PathVariable("name") String name, @RequestBody ExchangeMessageRequest body);
	
}
