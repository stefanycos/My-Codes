package br.com.souza.solutions.iorganize.service;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.models.Bank;
import br.com.souza.solutions.iorganize.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository repository;

	public Bank save(Bank bank) {
		return repository.save(bank);
	}

	public Optional<Bank> findById(Long id) {
		return repository.findById(id);
	}

	public Page<Bank> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository.findByStatus(pageable, getStatusValue(status));
	}

	public Bank findByName(String name) {
		return repository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank named " + name +  " not found"));
	}

	public void disable(Bank bank) {
		bank.setStatus(false);
		repository.save(bank);
	}

}
