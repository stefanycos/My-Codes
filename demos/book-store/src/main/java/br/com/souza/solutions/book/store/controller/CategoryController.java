package br.com.souza.solutions.book.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.book.store.controller.dto.CategoryDTO;
import br.com.souza.solutions.book.store.mapper.CategoryMapper;
import br.com.souza.solutions.book.store.models.Category;
import br.com.souza.solutions.book.store.service.CategoryService;

@RestController
@RequestMapping("v1/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private CategoryMapper mapper;

	@GetMapping("/{id}")
	public Category read(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
	}

	@GetMapping
	public List<Category> list() {
		return service.findAll();
	}

	@PostMapping
	public Category create(@RequestBody @Valid CategoryDTO body) {
		Category category = mapper.toCategory(body);
		return service.save(category);
	}

	@PutMapping("/{id}")
	public Category update(@PathVariable Long id, @RequestBody @Valid CategoryDTO body) {
		final Category category = read(id);
		return service.save(category);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		final Category category = read(id);
		service.delete(category);
	}
}
