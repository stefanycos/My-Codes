package br.com.souza.solutions.mongodb.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.mongodb.demo.models.Goal;

@Repository
public interface GoalRepository extends MongoRepository<Goal, String> {

	Optional<Goal> findByNameIgnoreCase(String name);

}
