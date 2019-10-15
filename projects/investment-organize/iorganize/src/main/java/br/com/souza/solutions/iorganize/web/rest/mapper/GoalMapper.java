package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.Goal;
import br.com.souza.solutions.iorganize.web.rest.dto.GoalDTO;

@Component
public class GoalMapper {

	public Page<GoalDTO> toGoalDTO(Page<Goal> goals) {
		return goals.map(GoalDTO::new);
	}

}