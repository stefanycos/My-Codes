package br.com.souza.solutions.iorganize.web.rest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.souza.solutions.iorganize.models.Account;
import br.com.souza.solutions.iorganize.models.Bank;
import br.com.souza.solutions.iorganize.service.BankService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountForm {
	
	@NotEmpty
	@NotNull
	private String bank;

	private String agency;
	
	private String number;
	
	private Boolean status;
	
	public Account converter(BankService bankService) {
		Bank bankName = bankService.findByName(bank);
		return Account.builder()
				.bank(bankName)
				.agency(agency)
				.number(number)
				.status(true).build();
	}
	
	public void updateRelatedEntities(Account account, BankService bankService) {

		if (bank != null) {
			account.setBank(bankService.findByName(bank));
		}

	}
}
