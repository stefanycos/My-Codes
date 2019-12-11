package br.com.souza.solutions.mongodb.demo.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = Investment.COLLECTION_NAME)
public class Investment {

	public static final String COLLECTION_NAME = "demo_investment";

	@Id
	private String id;

	@DBRef
	@NotNull
	private Goal goal;

	@DBRef
	@NotNull
	private InvestmentType investmentType;

	@DBRef
	@NotNull
	private Account account;

	@DBRef
	private User user;

	@NotNull
	private LocalDateTime applicationDate;

	private LocalDateTime dueDate;

	@NotNull
	private BigDecimal amount;

	private BigDecimal rate;

	private Double quantity;

}
