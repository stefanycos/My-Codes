package br.com.souza.solutions.iorganize.service;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.models.Goal;
import br.com.souza.solutions.iorganize.repository.GoalRepository;

@Service
public class GoalService {

	@Autowired
	private GoalRepository repository;

	public Goal save(Goal goal) {
		return repository.save(goal);
	}

	public Optional<Goal> findById(Long id) {
		return repository.findById(id);
	}

	public Page<Goal> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository.findByStatus(pageable, getStatusValue(status));
	}
	
	public Goal findByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal named [" + name +  "] not found"));
	}

	public void disable(Goal goal) {
		goal.setStatus(false);
		repository.save(goal);
	}

}
