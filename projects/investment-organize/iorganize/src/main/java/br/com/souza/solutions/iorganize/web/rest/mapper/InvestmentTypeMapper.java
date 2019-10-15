package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.InvestmentType;
import br.com.souza.solutions.iorganize.web.rest.dto.InvestmentTypeDTO;

@Component
public class InvestmentTypeMapper {

	public Page<InvestmentTypeDTO> toInvestmentTypeDTO(Page<InvestmentType> types) {
		return types.map(InvestmentTypeDTO::new);
	}

}