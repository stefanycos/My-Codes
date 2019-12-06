package br.com.souza.solutions.mongodb.demo.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = InvestmentType.COLLECTION_NAME)
public class InvestmentType {

	public static final String COLLECTION_NAME = "demo_investment_type";

	@Id
	private String id;

	@NotEmpty
	private String name;
}
