package com.springboot.mongodb.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.demo.models.Address;
import com.springboot.mongodb.demo.models.Hotel;
import com.springboot.mongodb.demo.models.Phone;
import com.springboot.mongodb.demo.models.Review;
import com.springboot.mongodb.demo.repository.HotelRepository;
import com.springboot.mongodb.demo.service.HotelService;
import com.springboot.mongodb.demo.service.PhoneService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepository repository;

	@Autowired
	private HotelService service;

	@Autowired
	private PhoneService phoneService;

	@GetMapping("/price")
	public List<Hotel> getByPrice() {
		return service.getByPrice();
	}

	@GetMapping
	public Page<Hotel> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Hotel get(@PathVariable("id") String id) {
		return repository.findById(id).get();
	}

	@PostMapping
	public void save() {
		Phone phone = phoneService.findOneByCriteria("number", "96459-8654");
		Hotel hotel = new Hotel("Ibis", 85, new Address("Rio de Janeiro", "Brazil"),
				Arrays.asList(new Review("John", 9, true)), phone);
		this.service.create(hotel);
	}

	@PutMapping
	public void update(@RequestBody Hotel hotel) {
		this.repository.save(hotel);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.repository.deleteById(id);
	}

}
