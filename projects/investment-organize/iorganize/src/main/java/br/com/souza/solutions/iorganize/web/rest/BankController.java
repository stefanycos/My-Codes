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
import br.com.souza.solutions.iorganize.models.Bank;
import br.com.souza.solutions.iorganize.service.BankService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.BankDTO;
import br.com.souza.solutions.iorganize.web.rest.form.BankForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.BankMapper;

@RestController
@RequestMapping("v1/api/banks")
public class BankController {

	@Autowired
	private BankService service;

	@Autowired
	private BankMapper mapper;

	@GetMapping
	public Page<BankDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<Bank> goals = service.findAll(pageable, status);
		return mapper.toBankDTO(goals);
	}

	@GetMapping("/{id}")
	public BankDTO get(@PathVariable Long id) {

		Bank bank = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new BankDTO(bank);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public BankDTO save(@RequestBody @Valid BankForm form) {
		Bank bank = form.converter();
		bank = service.save(bank);

		return new BankDTO(bank);
	}

	@PutMapping("/{id}")
	@Transactional
	public BankDTO update(@PathVariable Long id, @RequestBody BankForm form) {

		Bank bank = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, bank);

		return new BankDTO(bank);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		Bank bank = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(bank);
	}

}
