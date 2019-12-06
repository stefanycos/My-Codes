package br.com.souza.solutions.mongodb.demo.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = Bank.COLLECTION_NAME)
public class Bank {

	public static final String COLLECTION_NAME = "demo_bank";

	@Id
	private String id;

	@NotEmpty
	private String name;

	private String code;
}
