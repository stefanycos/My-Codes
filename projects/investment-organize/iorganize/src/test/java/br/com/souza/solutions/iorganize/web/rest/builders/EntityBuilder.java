package br.com.souza.solutions.iorganize.web.rest.builders;

import java.math.BigDecimal;

import br.com.souza.solutions.iorganize.models.Goal;
import br.com.souza.solutions.iorganize.utils.ConstantsTests;
import br.com.souza.solutions.iorganize.web.rest.form.GoalForm;

public class EntityBuilder {
	
	private EntityBuilder() {
	}
	
	public static Goal buildGoal() {
		return new Goal(1L, ConstantsTests.GOAL_NAME, true, new BigDecimal(10000));
	}
	
	public static GoalForm buildGoalForm(String name) {
		return new GoalForm(name, true, new BigDecimal(10000));
	}

}
