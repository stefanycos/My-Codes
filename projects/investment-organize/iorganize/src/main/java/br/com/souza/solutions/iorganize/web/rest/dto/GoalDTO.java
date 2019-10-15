package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import java.math.BigDecimal;

import br.com.souza.solutions.iorganize.models.Goal;
import lombok.Data;

@Data
public class GoalDTO {

	private Long id;

	private String name;

	private String status;
	
	private BigDecimal value;

	public GoalDTO(Goal goal) {
		this.id = goal.getId();
		this.name = goal.getName();
		this.status = getStatusDescription(goal.getStatus());
		this.value = goal.getValue();
	}

}
