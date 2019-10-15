package br.com.souza.solutions.iorganize.web.rest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.souza.solutions.iorganize.models.InvestmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentTypeForm {

	@NotEmpty
	@NotNull
	private String name;

	private Boolean status;
	
	private Double value;
	
	public InvestmentType converter() {
		return InvestmentType.builder()
				.name(name)
				.status(true).build();
	}
}
