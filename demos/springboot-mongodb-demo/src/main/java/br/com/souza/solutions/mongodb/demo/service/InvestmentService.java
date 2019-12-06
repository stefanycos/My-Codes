package br.com.souza.solutions.mongodb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.mongodb.demo.filters.InvestmentFilter;
import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.models.Investment;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.models.User;
import br.com.souza.solutions.mongodb.demo.repository.InvestmentRepository;
import br.com.souza.solutions.mongodb.demo.service.query.InvestmentQueryFactory;

@Service
public class InvestmentService extends CrudService<Investment, String> {

	@Autowired
	private MongoTemplate mongoTemplate;

	private InvestmentQueryFactory queryFactory;

	public InvestmentService(InvestmentRepository repository, InvestmentQueryFactory queryFactory) {
		super(repository);
		this.queryFactory = queryFactory;
	}

	public Page<Investment> findAll(Pageable pageable, InvestmentFilter filters) {
		Query query = queryFactory.getQuery(filters);
		query.with(pageable);

		List<Investment> content = mongoTemplate.find(query, Investment.class);
		return PageableExecutionUtils.getPage(content, pageable, () -> mongoTemplate.count(query, Investment.class));
	}

	public Page<Investment> findAllByUser(Pageable pageable, User user) {
		return ((InvestmentRepository) repository).findAllByUser(pageable, user);
	}

	public List<Investment> findAllByGoal(Goal goal) {
		return ((InvestmentRepository) repository).findAllByGoal(goal);
	}

	public List<Investment> findAllByAccount(Account account) {
		return ((InvestmentRepository) repository).findAllByAccount(account);
	}

	public List<Investment> findAllByInvestmentType(InvestmentType investmentType) {
		return ((InvestmentRepository) repository).findAllByInvestmentType(investmentType);
	}

}
