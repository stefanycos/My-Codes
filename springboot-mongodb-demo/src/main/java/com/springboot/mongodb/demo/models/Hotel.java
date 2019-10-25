package com.springboot.mongodb.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Hotels")
@NoArgsConstructor
public class Hotel {

	@Id
	private String id;

	private String name;

	private int pricePerNight;

	private Address address;
	
	@DBRef
	private Phone phone;

	private List<Review> reviews = new ArrayList<>();

	public Hotel(String name, int pricePerNight, Address address, List<Review> reviews, Phone phone) {
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
		this.phone = phone;
	}

}
