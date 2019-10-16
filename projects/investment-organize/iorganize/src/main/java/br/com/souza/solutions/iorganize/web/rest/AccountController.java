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
import br.com.souza.solutions.iorganize.models.Account;
import br.com.souza.solutions.iorganize.service.AccountService;
import br.com.souza.solutions.iorganize.service.BankService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.AccountDTO;
import br.com.souza.solutions.iorganize.web.rest.form.AccountForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.AccountMapper;

@RestController
@RequestMapping("v1/api/accounts")
public class AccountController {

	@Autowired
	private AccountService service;
	
	@Autowired
	private BankService bankService;

	@Autowired
	private AccountMapper mapper;

	@GetMapping
	public Page<AccountDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<Account> goals = service.findAll(pageable, status);
		return mapper.toAccountDTO(goals);
	}

	@GetMapping("/{id}")
	public AccountDTO get(@PathVariable Long id) {

		Account account = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new AccountDTO(account);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDTO save(@RequestBody @Valid AccountForm form) {
		Account account = form.converter(bankService);
		account = service.save(account);

		return new AccountDTO(account);
	}

	@PutMapping("/{id}")
	@Transactional
	public AccountDTO update(@PathVariable Long id, @RequestBody AccountForm form) {

		Account account = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, account);

		return new AccountDTO(account);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		Account account = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(account);
	}

}
