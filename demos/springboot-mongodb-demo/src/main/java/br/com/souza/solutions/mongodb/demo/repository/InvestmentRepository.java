package br.com.souza.solutions.mongodb.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.models.Investment;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.models.User;

@Repository
public interface InvestmentRepository extends MongoRepository<Investment, String> {

	List<Investment> findAllByAccount(Account account);

	List<Investment> findAllByGoal(Goal goal);

	List<Investment> findAllByInvestmentType(InvestmentType investmentType);

	Page<Investment> findAllByUser(Pageable pageable, User user);

}
