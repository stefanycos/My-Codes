package br.com.souza.solutions.book.store.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

	@NotEmpty
	@NotNull
	private String name;

	@NotEmpty
	@NotNull
	private Integer numberOfPages;

	private String sinopse;

	@Valid
	private CategoryDTO category;

}
