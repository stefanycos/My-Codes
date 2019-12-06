package br.com.souza.solutions.mongodb.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.repository.BankRepository;
import br.com.souza.solutions.mongodb.demo.repository.InvestmentTypeRepository;

@Service
public class InvestmentTypeService extends CrudService<InvestmentType, String> {

	private InvestmentService investmentService;

	public InvestmentTypeService(InvestmentTypeRepository repository, InvestmentService investmentService) {
		super(repository);
		this.investmentService = investmentService;
	}

	@Override
	public void save(InvestmentType investmentType) {
		if (exists(investmentType.getName())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Name is already registered");
		}

		super.save(investmentType);
	}

	public Optional<InvestmentType> findByName(String name) {
		return ((InvestmentTypeRepository) repository).findByNameIgnoreCase(name);
	}

	@Override
	public void delete(InvestmentType investmentType) {
		if (isInUse(investmentType)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"InvestmentType is been used and cant be deleted");
		}

		super.delete(investmentType);
	}

	private boolean exists(String name) {
		Optional<InvestmentType> optional = ((InvestmentTypeRepository) repository).findByNameIgnoreCase(name);
		return optional.isPresent();
	}

	private boolean isInUse(InvestmentType investmentType) {
		return investmentService.findAllByInvestmentType(investmentType).isEmpty();
	}
}
