package com.springboot.mongodb.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "phone")
@NoArgsConstructor
public class Phone {

	@Id
	private String id;

	private PhoneType phoneType;

	private String number;

	public Phone(PhoneType phoneType, String number) {
		this.phoneType = phoneType;
		this.number = number;
	}

}
