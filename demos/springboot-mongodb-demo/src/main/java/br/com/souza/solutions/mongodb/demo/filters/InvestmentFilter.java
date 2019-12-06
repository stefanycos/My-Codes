package br.com.souza.solutions.mongodb.demo.filters;

import java.time.LocalDateTime;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvestmentFilter {

	private Goal goal;

	private InvestmentType type;

	private Account account;
	
	private LocalDateTime dueDate;
}
