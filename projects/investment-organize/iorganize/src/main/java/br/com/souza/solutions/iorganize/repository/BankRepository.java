package br.com.souza.solutions.iorganize.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Page<Bank> findByStatus(Pageable pageable, boolean status);

	Optional<Bank> findByName(String name);
}