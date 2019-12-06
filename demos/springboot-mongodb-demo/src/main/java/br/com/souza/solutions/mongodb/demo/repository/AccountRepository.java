package br.com.souza.solutions.mongodb.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.mongodb.demo.models.Account;
import br.com.souza.solutions.mongodb.demo.models.User;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	Page<Account> findAllByUser(Pageable pageable, User user);

}
