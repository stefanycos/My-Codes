package br.com.springboot.events.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private String id;
	
	private String name;
	
	private Double value;
}
