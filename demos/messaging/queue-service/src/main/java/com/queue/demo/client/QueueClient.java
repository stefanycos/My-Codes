package com.queue.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.queue.demo.client.domains.request.queue.QueueRequest;
import com.queue.demo.client.domains.response.queue.QueueResponse;
import com.queue.demo.config.feign.FeignClientConfiguration;

@FeignClient(name = "queue-client", url = "${rabbitmq.baseUrl}", path = "/queues", configuration = FeignClientConfiguration.class)
public interface QueueClient {

	@GetMapping
	QueueResponse[] geQueues();

	@PutMapping("/{vhost}/{name}")
	void create(@PathVariable("vhost") String vhost, @PathVariable("name") String name, @RequestBody QueueRequest queueRequest);
	
	@DeleteMapping("/{vhost}/{name}")
	void delete(@PathVariable("vhost") String vhost, @PathVariable("name") String name, @RequestParam(name = "if-unused") Boolean ifUnused, @RequestParam(name = "if-empty") Boolean ifEmpty);

}
