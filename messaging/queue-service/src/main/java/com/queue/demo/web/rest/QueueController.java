package com.queue.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.queue.demo.client.QueueClient;
import com.queue.demo.client.domains.request.queue.QueueRequest;
import com.queue.demo.client.domains.response.queue.QueueResponse;

@RestController
@RequestMapping("/queues")
public class QueueController {

	@Autowired
	private QueueClient queueClient;

	@GetMapping
	public QueueResponse[] getQueues() {
		return queueClient.geQueues();
	}
	
	@PutMapping("/{vhost}/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Queue was created successfully")
	public void create(@PathVariable("vhost") String vhost, 
					   @PathVariable("name") String name,
					   @RequestBody QueueRequest body) {

		queueClient.create(vhost, name, body);
	}
	
	@DeleteMapping("/{vhost}/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Queue was deleted successfully")
	public void delete(@PathVariable("vhost") String vhost, 
					   @PathVariable("name") String name,
					   @RequestParam(name = "if-unused", required = true) Boolean ifUnused,
					   @RequestParam(name = "if-empty", required = true) Boolean ifEmpty) {

		queueClient.delete(vhost, name, ifUnused, ifEmpty);
	}

}
