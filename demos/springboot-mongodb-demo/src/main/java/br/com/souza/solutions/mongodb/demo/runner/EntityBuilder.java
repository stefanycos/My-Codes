package br.com.souza.solutions.mongodb.demo.runner;

import java.math.BigDecimal;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.Bank;
import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.models.User;

public class EntityBuilder {

	private EntityBuilder() {
	}

	// @formatter:off
	
	public static Goal buildGoal() {
		return Goal.builder()
						.name("Trip")
						.amount(new BigDecimal(15000)).build();
	}
	
	public static InvestmentType buildInvestmentType() {
		return InvestmentType.builder().name("Fundo Imobiliario").build();
	}
	
	public static Bank buildBank() {
		return Bank.builder()
					.name("NuBank")
					.code("0358").build();
	}
	
	public static Account buildAccount(Bank bank, User user) {
		return Account.builder()
					.agency("0369")
					.bank(bank)
					.number("123456")
					.user(user).build();
	}
	
	public static User buildUser() {
		return User.builder()
						.email("admin@admin.com")
						.isAdmin(true)
						.name("User Admin")
						.password("******").build();
						
	}
	
	// @formatter:on
}
