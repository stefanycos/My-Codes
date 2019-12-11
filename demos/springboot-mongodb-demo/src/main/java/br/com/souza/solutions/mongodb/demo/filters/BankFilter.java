package br.com.souza.solutions.mongodb.demo.filters;

import org.springframework.data.domain.Sort.Direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankFilter {

	private String name;

	private Direction sortDirection;

	private String sortBy;
}
