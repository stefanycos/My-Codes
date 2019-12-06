package br.com.souza.solutions.mongodb.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.mongodb.demo.models.Bank;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {

	Optional<Bank> findByNameIgnoreCase(String name);

}
