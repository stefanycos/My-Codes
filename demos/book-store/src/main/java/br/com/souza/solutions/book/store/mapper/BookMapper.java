package br.com.souza.solutions.book.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.book.store.controller.dto.BookDTO;
import br.com.souza.solutions.book.store.models.Book;
import br.com.souza.solutions.book.store.models.Category;
import br.com.souza.solutions.book.store.service.CategoryService;

@Component
public class BookMapper {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CategoryService categoryService;

	public Book toBook(BookDTO bookDTO) {
		Book book = mapper.map(bookDTO, Book.class);
		book.setCategory(getCategory(bookDTO.getCategory().getName()));
		return book;
	}

	private Category getCategory(String name) {
		return categoryService.findByName(name).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category named " + name + " not found"));
	}
}
