package com.springboot.mongodb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.demo.models.Phone;

@Service
public class PhoneService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Phone create(Phone phone) {
		return mongoTemplate.insert(phone);
	}

	public void delete(String id) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Phone.class);
	}

	public List<Phone> findAll() {
		return mongoTemplate.findAll(Phone.class);
	}

	public Phone findOneByCriteria(String criteria, String value) {
		return mongoTemplate.findOne(new Query(Criteria.where(criteria).is(value)), Phone.class);
	}
}
