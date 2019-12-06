package br.com.souza.solutions.mongodb.demo.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = Goal.COLLECTION_NAME)
public class Goal {

	public static final String COLLECTION_NAME = "demo_goal";

	@Id
	private String id;

	@NotEmpty
	private String name;

	private BigDecimal amount;

}
