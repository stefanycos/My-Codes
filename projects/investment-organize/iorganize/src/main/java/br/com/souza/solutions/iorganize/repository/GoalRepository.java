package br.com.souza.solutions.iorganize.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
	
	Page<Goal> findByStatus(Pageable pageable, boolean status);
	
	Optional<Goal> findByName(String name);

}
