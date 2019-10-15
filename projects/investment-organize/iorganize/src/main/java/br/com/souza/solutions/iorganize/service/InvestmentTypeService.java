package br.com.souza.solutions.iorganize.service;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.iorganize.models.InvestmentType;
import br.com.souza.solutions.iorganize.repository.InvestmentTypeRepository;

@Service
public class InvestmentTypeService {

	@Autowired
	private InvestmentTypeRepository repository;

	public InvestmentType save(InvestmentType type) {
		return repository.save(type);
	}

	public Optional<InvestmentType> findById(Long id) {
		return repository.findById(id);
	}

	public Page<InvestmentType> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository. findByStatus(pageable, getStatusValue(status));
	}

	public void disable(InvestmentType type) {
		type.setStatus(false);
		repository.save(type);
	}

}
