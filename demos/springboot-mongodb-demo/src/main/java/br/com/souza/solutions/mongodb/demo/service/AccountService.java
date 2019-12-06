package br.com.souza.solutions.mongodb.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.User;
import br.com.souza.solutions.mongodb.demo.repository.AccountRepository;

@Service
public class AccountService extends CrudService<Account, String> {

	private InvestmentService investmentService;

	public AccountService(AccountRepository repository, InvestmentService investmentService) {
		super(repository);
		this.investmentService = investmentService;
	}

	public Page<Account> findAllByUser(Pageable pageable, User user) {
		return ((AccountRepository) repository).findAllByUser(pageable, user);
	}

	@Override
	public void delete(Account account) {
		if (isInUse(account)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account is been used and cant be deleted");
		}

		super.delete(account);
	}

	private boolean isInUse(Account account) {
		return investmentService.findAllByAccount(account).isEmpty();
	}

}
