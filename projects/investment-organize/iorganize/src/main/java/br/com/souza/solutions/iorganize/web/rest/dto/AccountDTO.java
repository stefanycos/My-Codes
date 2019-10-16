package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import br.com.souza.solutions.iorganize.models.Account;
import lombok.Data;

@Data
public class AccountDTO {

	private Long id;

	private String bank;
	
	private String agency;
	
	private String number;

	private String status;
	
	public AccountDTO(Account account) {
		this.id = account.getId();
		this.bank = account.getBank().getName();
		this.agency = account.getAgency();
		this.number = account.getNumber();
		this.status = getStatusDescription(account.getStatus());
	}

}
