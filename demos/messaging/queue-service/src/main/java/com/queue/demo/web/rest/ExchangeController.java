package com.queue.demo.web.rest;

import javax.validation.Valid;

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

import com.queue.demo.client.ExchangeClient;
import com.queue.demo.client.domains.request.exchange.ExchangeRequest;
import com.queue.demo.client.domains.response.exhange.ExchangeResponse;
import com.queue.demo.web.rest.dto.ExchangeDTO;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

	@Autowired
	private ExchangeClient exchangeClient;

	@GetMapping
	public ExchangeDTO[] getExchanges() {
		ExchangeResponse[] exchanges = exchangeClient.getExchanges();
		return ExchangeDTO.conveter(exchanges);
	}

	@PutMapping("/{vhost}/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Exchange was created successfully")
	public void create(@PathVariable("vhost") String vhost, 
					   @PathVariable("name") String name,
					   @Valid @RequestBody ExchangeRequest body) {

		exchangeClient.create(vhost, name, body);
	}

	@DeleteMapping("/{vhost}/{name}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Exchange was deleted successfully")
	public void delete(@PathVariable("vhost") String vhost, 
					   @PathVariable("name") String name,
					   @RequestParam(name = "if-unused", required = true) Boolean ifUnused) {

		exchangeClient.delete(vhost, name, ifUnused);
	}

}
