package br.com.souza.solutions.iorganize.service;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.iorganize.models.Investment;
import br.com.souza.solutions.iorganize.repository.InvestmentRepository;

@Service
public class InvestmentService {

	@Autowired
	private InvestmentRepository repository;

	public Investment save(Investment type) {
		return repository.save(type);
	}

	public Optional<Investment> findById(Long id) {
		return repository.findById(id);
	}

	public Page<Investment> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository.findByStatus(pageable, getStatusValue(status));
	}

	public void disable(Investment type) {
		type.setStatus(false);
		repository.save(type);
	}

}
