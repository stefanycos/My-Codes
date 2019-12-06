package br.com.souza.solutions.mongodb.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.repository.GoalRepository;

@Service
public class GoalService extends CrudService<Goal, String> {

	private InvestmentService investmentService;

	public GoalService(GoalRepository repository, InvestmentService investmentService) {
		super(repository);
		this.investmentService = investmentService;
	}

	@Override
	public void save(Goal goal) {
		if (exists(goal.getName())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Name is already registered");
		}

		super.save(goal);
	}

	@Override
	public void delete(Goal goal) {
		if (isInUse(goal)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Goal is been used and cant be deleted");
		}

		super.delete(goal);
	}

	private boolean exists(String name) {
		Optional<Goal> optional = ((GoalRepository) repository).findByNameIgnoreCase(name);
		return optional.isPresent();
	}

	private boolean isInUse(Goal goal) {
		return investmentService.findAllByGoal(goal).isEmpty();
	}
}
