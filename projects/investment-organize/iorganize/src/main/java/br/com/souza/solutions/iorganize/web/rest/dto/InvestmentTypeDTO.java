package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import br.com.souza.solutions.iorganize.models.InvestmentType;
import lombok.Data;

@Data
public class InvestmentTypeDTO {

	private Long id;

	private String name;

	private String status;

	public InvestmentTypeDTO(InvestmentType type) {
		this.id = type.getId();
		this.name = type.getName();
		this.status = getStatusDescription(type.getStatus());
	}

}
