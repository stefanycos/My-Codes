package br.com.souza.solutions.mongodb.demo.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collation = User.COLLECTION_NAME)
public class User {

	public static final String COLLECTION_NAME = "demo_user";

	@Id
	private String id;

	@NotEmpty
	private String email;

	@NotEmpty
	private String name;

	@NotEmpty
	private String password;

	@NotEmpty
	private Boolean isAdmin;

}
