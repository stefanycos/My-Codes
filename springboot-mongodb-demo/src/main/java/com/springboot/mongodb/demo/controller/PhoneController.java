package com.springboot.mongodb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.demo.models.Phone;
import com.springboot.mongodb.demo.service.PhoneService;

@RestController
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@GetMapping
	public List<Phone> getAll() {
		return phoneService.findAll();
	}

	@PostMapping
	public Phone create(@RequestBody Phone phone) {
		return phoneService.create(phone);
	}
}
