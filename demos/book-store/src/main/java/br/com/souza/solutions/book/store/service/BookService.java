package br.com.souza.solutions.book.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.souza.solutions.book.store.models.Book;
import br.com.souza.solutions.book.store.repository.BookRepository;

@Service
public class BookService {

	private BookRepository repository;

	public BookService(BookRepository categoryRepository) {
		this.repository = categoryRepository;
	}

	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Book save(Book book) {
		return repository.save(book);
	}

	public void delete(Book book) {
		repository.delete(book);
	}

}
