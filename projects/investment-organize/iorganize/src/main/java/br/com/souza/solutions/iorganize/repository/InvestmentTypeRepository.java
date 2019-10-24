package br.com.souza.solutions.iorganize.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.InvestmentType;

@Repository
public interface InvestmentTypeRepository extends JpaRepository<InvestmentType, Long> {
	
	Page<InvestmentType> findByStatus(Pageable pageable, boolean status);
	
	Optional<InvestmentType> findByName(String name);

}
