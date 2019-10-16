package br.com.souza.solutions.iorganize.web.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.commons.Constants;
import br.com.souza.solutions.iorganize.models.Goal;
import br.com.souza.solutions.iorganize.service.GoalService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.GoalDTO;
import br.com.souza.solutions.iorganize.web.rest.form.GoalForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.GoalMapper;

@RestController
@RequestMapping("v1/api/goals")
public class GoalController {

	@Autowired
	private GoalService service;

	@Autowired
	private GoalMapper mapper;

	@GetMapping
	public Page<GoalDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<Goal> goals = service.findAll(pageable, status);
		return mapper.toGoalDTO(goals);
	}

	@GetMapping("/{id}")
	public GoalDTO get(@PathVariable Long id) {

		Goal goal = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new GoalDTO(goal);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public GoalDTO save(@RequestBody @Valid GoalForm form) {
		Goal goal = form.converter();
		goal = service.save(goal);

		return new GoalDTO(goal);
	}

	@PutMapping("/{id}")
	@Transactional
	public GoalDTO update(@PathVariable Long id, @RequestBody GoalForm form) {

		Goal goal = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, goal);

		return new GoalDTO(goal);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		Goal goal = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(goal);
	}

}
