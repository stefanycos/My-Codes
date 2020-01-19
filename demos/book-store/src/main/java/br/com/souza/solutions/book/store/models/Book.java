package br.com.souza.solutions.book.store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(name = "number_of_pages", nullable = false)
	private Integer numberOfPages;

	private String sinopse;

	@ManyToOne(optional = false)
	private Category category;

}
