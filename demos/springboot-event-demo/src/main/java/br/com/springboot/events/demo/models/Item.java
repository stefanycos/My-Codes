package br.com.springboot.events.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

	private Product product;

	private Integer quantity;

	@Override
	public String toString() {
		return "Item [product=" + product + " | quantity=" + quantity + "]";
	}
	
	
}
