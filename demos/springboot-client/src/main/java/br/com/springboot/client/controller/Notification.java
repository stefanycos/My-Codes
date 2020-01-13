package br.com.springboot.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/receive")
public class Notification {

	private static final Logger logger = LoggerFactory.getLogger(Notification.class);

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void receiveNotification(@RequestBody Object body) {
		logger.info("Notification received successfully");
		logger.info("Payload {}", body);
	}
}
