package br.com.souza.solutions.mongodb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.mongodb.demo.filters.BankFilter;
import br.com.souza.solutions.mongodb.demo.models.Bank;
import br.com.souza.solutions.mongodb.demo.repository.BankRepository;
import br.com.souza.solutions.mongodb.demo.service.query.BankQueryFactory;

@Service
public class BankService extends CrudService<Bank, String> {

	@Autowired
	private MongoTemplate mongoTemplate;

	private BankQueryFactory queryFactory;

	public BankService(BankRepository repository, BankQueryFactory queryFactory) {
		super(repository);
		this.queryFactory = queryFactory;
	}

	@Override
	public void save(Bank bank) {
		if (exists(bank.getName())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Name is already registered");
		}

		super.save(bank);
	}

	public Page<Bank> findAll(Pageable pageable, BankFilter filters) {
		Query query = queryFactory.getQuery(filters);
		query.with(pageable);

		List<Bank> content = mongoTemplate.find(query, Bank.class);
		return PageableExecutionUtils.getPage(content, pageable, () -> mongoTemplate.count(query, Bank.class));
	}

	private boolean exists(String name) {
		Optional<Bank> optional = ((BankRepository) repository).findByNameIgnoreCase(name);
		return optional.isPresent();
	}
}
