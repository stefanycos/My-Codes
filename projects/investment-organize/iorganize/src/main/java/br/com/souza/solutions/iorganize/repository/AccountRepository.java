package br.com.souza.solutions.iorganize.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.Account;
import br.com.souza.solutions.iorganize.models.Bank;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Page<Account> findByStatus(Pageable pageable, boolean status);
}