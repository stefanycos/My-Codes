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

import br.com.souza.solutions.book.store.controller.dto.BookDTO;
import br.com.souza.solutions.book.store.mapper.BookMapper;
import br.com.souza.solutions.book.store.models.Book;
import br.com.souza.solutions.book.store.service.BookService;

@RestController
@RequestMapping("v1/api/books")
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private BookMapper mapper;

	@GetMapping("/{id}")
	public Book read(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
	}

	@GetMapping
	public List<Book> list() {
		return service.findAll();
	}

	@PostMapping
	public Book create(@RequestBody @Valid BookDTO body) {
		Book book = mapper.toBook(body);
		return service.save(book);
	}

	@PutMapping("/{id}")
	public Book update(@PathVariable Long id, @RequestBody @Valid BookDTO body) {
		final Book book = read(id);
		return service.save(book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		final Book book = read(id);
		service.delete(book);
	}
}
