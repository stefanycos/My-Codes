package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import br.com.souza.solutions.iorganize.models.Bank;
import lombok.Data;

@Data
public class BankDTO {

	private Long id;

	private String name;

	private String status;

	public BankDTO(Bank bank) {
		this.id = bank.getId();
		this.name = bank.getName();
		this.status = getStatusDescription(bank.getStatus());
	}

}
