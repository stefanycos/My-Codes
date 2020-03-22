package br.com.souza.solutions.book.store.controller.dto;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	
	@NotEmpty
	@NotNull
	private String name;

}
