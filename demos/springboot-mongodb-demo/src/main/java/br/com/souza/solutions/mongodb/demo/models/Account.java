package br.com.souza.solutions.mongodb.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation = Account.COLLECTION_NAME)
public class Account {

	public static final String COLLECTION_NAME = "demo_account";

	@Id
	private String id;

	@DBRef
	private Bank bank;
	
	@DBRef
	private User user;

	private String number;

	private String agency;

}
