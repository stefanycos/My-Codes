package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.Investment;
import br.com.souza.solutions.iorganize.web.rest.dto.InvestmentDTO;

@Component
public class InvestmentMapper {

	public Page<InvestmentDTO> toInvestmentDTO(Page<Investment> investments) {
		return investments.map(InvestmentDTO::new);
	}

}