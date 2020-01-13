package br.com.springboot.events.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.springboot.events.demo.models.Order;
import br.com.springboot.events.demo.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public Order create() {
		return service.create();
	}

	@GetMapping
	public List<Order> list() {
		return service.findAll();
	}

	@PutMapping("{id}/status")
	public Order status(@PathVariable String id) {
		Order order = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
		
		service.changeStatus(order);
		return order;
	}

}
