package br.com.springboot.events.demo.service;

import br.com.springboot.events.demo.models.Product;

public class ProductService {

	private ProductService() {
	}

	// @formatter:off
	
	public static Product getGameProduct() {
		return Product.builder()
						.id("5d7a45705c422c7cc888eea7")
						.name("Call of Duty")
						.value(150.59).build();
	}
	
	public static Product getNotebookProduct() {
		return Product.builder()
				.id("5d7a45705c422c7cc8698eea6")
				.name("Dell Inspiron 16")
				.value(4300.00).build();
	}
	
	// @formatter:on
}
