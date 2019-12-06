package br.com.souza.solutions.mongodb.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudService<T, ID> { // NOSONAR

	protected MongoRepository<T, ID> repository;

	public CrudService(MongoRepository<T, ID> repository) {
		this.repository = repository;
	}

	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public void save(T entity) {
		repository.save(entity);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

}
