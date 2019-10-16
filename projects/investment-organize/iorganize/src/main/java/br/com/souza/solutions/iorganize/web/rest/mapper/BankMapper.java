package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.Bank;
import br.com.souza.solutions.iorganize.web.rest.dto.BankDTO;

@Component
public class BankMapper {

	public Page<BankDTO> toBankDTO(Page<Bank> banks) {
		return banks.map(BankDTO::new);
	}

}