package br.com.springboot.events.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.springboot.events.demo.models.Order;

@Component
public class WebhookSender {

	private static Logger logger = LoggerFactory.getLogger(WebhookSender.class);

	@Value("${app.webhook.callbackURL}")
	private String callbackURL;

	private RestTemplate restTemplate = new RestTemplate();

	public void sendNotification(Order order) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

			HttpEntity<Object> entity = new HttpEntity<>(order, headers);

			ResponseEntity<String> response = restTemplate.exchange(callbackURL, HttpMethod.POST, entity, String.class);
			logger.info("Order notification was sent successfully. Response body [{}]", response);
		} catch (RestClientException e) {
			logger.error("Couldn't sent order notification, error [{}]", e.getMessage());
		}

	}
}
