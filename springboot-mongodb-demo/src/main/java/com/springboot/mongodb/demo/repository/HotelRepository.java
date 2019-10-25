package com.springboot.mongodb.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongodb.demo.models.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	


}