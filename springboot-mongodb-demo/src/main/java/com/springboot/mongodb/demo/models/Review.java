package com.springboot.mongodb.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	private String username;
	
	private int rating;
	
	private boolean approved;

}
