package com.producer.demo.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.demo.publisher.MessagePublisher;
import com.producer.demo.publisher.dto.RequestBodyDTO;

@RestController
@RequestMapping("/publish")
public class PublisherController {

	@Autowired
	private MessagePublisher publisher;

	@PostMapping
	public void publish(@Valid @RequestBody RequestBodyDTO request) {
		publisher.sendMessage(request);
	}

}
