package br.com.souza.solutions.mongodb.demo.runner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.Bank;
import br.com.souza.solutions.mongodb.demo.models.Goal;
import br.com.souza.solutions.mongodb.demo.models.Investment;
import br.com.souza.solutions.mongodb.demo.models.InvestmentType;
import br.com.souza.solutions.mongodb.demo.models.User;
import br.com.souza.solutions.mongodb.demo.service.AccountService;
import br.com.souza.solutions.mongodb.demo.service.BankService;
import br.com.souza.solutions.mongodb.demo.service.GoalService;
import br.com.souza.solutions.mongodb.demo.service.InvestmentService;
import br.com.souza.solutions.mongodb.demo.service.InvestmentTypeService;

@Component
public class Runner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankService bankService;

	@Autowired
	private InvestmentTypeService investmentTypeService;

	@Autowired
	private GoalService goalService;

	@Autowired
	private InvestmentService investmentService;

	@Override
	public void run(String... args) throws Exception {

		Bank bank = createBank();
		Account account = createAccount(bank, null);
		Goal goal = createGoal();
		InvestmentType investmentType = createInvestmentType();

		Investment investment = Investment.builder() // @formatter:off
									.account(account)
									.amount(new BigDecimal(30000))
									.applicationDate(LocalDateTime.now())
									.dueDate(LocalDateTime.now().plusDays(720))
									.quantity(10.0)
									.rate(BigDecimal.valueOf(5.3))
									.investmentType(investmentType)
									.goal(goal).build(); // @formatter:on

		investmentService.save(investment);
		investmentService.findAll(PageRequest.of(0, 20)).forEach(result -> logger.info("{}", result));

	}

	private Account createAccount(Bank bank, User user) {
		Account account = EntityBuilder.buildAccount(bank, user);
		accountService.save(account);
		logger.info("Account created successfully: {}", account);
		return account;
	}

	private Bank createBank() {
		Bank bank = EntityBuilder.buildBank();
		bankService.save(bank);
		logger.info("Bank created successfully: {}", bank);
		return bank;
	}

	private InvestmentType createInvestmentType() {
		InvestmentType investmentType = EntityBuilder.buildInvestmentType();
		investmentTypeService.save(investmentType);
		logger.info("Investment Type created successfully: {}", investmentType);
		return investmentType;
	}

	private Goal createGoal() {
		Goal goal = EntityBuilder.buildGoal();
		goalService.save(goal);
		logger.info("Goal created successfully: {}", goal);
		return goal;
	}

}
