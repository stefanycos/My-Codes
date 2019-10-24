package br.com.souza.solutions.iorganize.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

	Page<Investment> findByStatus(Pageable pageable, boolean status);

}
