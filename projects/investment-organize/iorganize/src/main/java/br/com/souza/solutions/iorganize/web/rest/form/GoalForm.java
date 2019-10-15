package br.com.souza.solutions.iorganize.web.rest.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.souza.solutions.iorganize.models.Goal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoalForm {

	@NotEmpty
	@NotNull
	private String name;

	private Boolean status;
	
	private BigDecimal value;
	
	public Goal converter() {
		return Goal.builder()
				.name(name)
				.status(true)
				.value(value).build();
	}
}
