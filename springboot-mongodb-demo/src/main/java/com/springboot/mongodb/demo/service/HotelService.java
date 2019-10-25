package com.springboot.mongodb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.demo.models.Hotel;

@Service
public class HotelService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Hotel> getByPrice() {
		Query query = new Query();
		query.addCriteria(Criteria.where("pricePerNight").lt(130));

		return mongoTemplate.find(query, Hotel.class);
	}
	
	public Hotel create(Hotel hotel) {
		return mongoTemplate.insert(hotel);
	}
	
	public Page<Hotel> getAll() {
		Pageable pageable = PageRequest.of(0, 1);
		
		Query query = new Query().with(pageable);
		List<Hotel> content =mongoTemplate.find(query, Hotel.class);
		Page<Hotel> hotelPages = PageableExecutionUtils.getPage(content, pageable, () -> mongoTemplate.count(query, Hotel.class));
		
		return hotelPages;
	}
}
