package br.com.souza.solutions.book.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.souza.solutions.book.store.models.Category;
import br.com.souza.solutions.book.store.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository repository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.repository = categoryRepository;
	}

	public Optional<Category> findById(Long id) {
		return repository.findById(id);
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category save(Category category) {
		return repository.save(category);
	}

	public void delete(Category category) {
		repository.delete(category);
	}

	public Optional<Category> findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}

}
