package br.com.souza.solutions.book.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.book.store.models.Book;
import br.com.souza.solutions.book.store.models.Category;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public Optional<Book> findByCategory(Category category);
}
