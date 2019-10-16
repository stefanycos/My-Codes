package br.com.souza.solutions.iorganize.web.rest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.souza.solutions.iorganize.models.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankForm {

	@NotEmpty
	@NotNull
	private String name;

	private Boolean status;
	
	public Bank converter() {
		return Bank.builder()
				.name(name)
				.status(true).build();
	}
}
