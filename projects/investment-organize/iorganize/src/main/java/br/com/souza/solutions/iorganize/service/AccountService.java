package br.com.souza.solutions.iorganize.service;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.iorganize.models.Account;
import br.com.souza.solutions.iorganize.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Account save(Account account) {
		return repository.save(account);
	}

	public Optional<Account> findById(Long id) {
		return repository.findById(id);
	}

	public Page<Account> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository.findByStatus(pageable, getStatusValue(status));
	}

	public void disable(Account account) {
		account.setStatus(false);
		repository.save(account);
	}

}
