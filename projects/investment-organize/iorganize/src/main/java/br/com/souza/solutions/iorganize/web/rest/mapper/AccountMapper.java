package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.Account;
import br.com.souza.solutions.iorganize.web.rest.dto.AccountDTO;

@Component
public class AccountMapper {

	public Page<AccountDTO> toAccountDTO(Page<Account> accounts) {
		return accounts.map(AccountDTO::new);
	}

}