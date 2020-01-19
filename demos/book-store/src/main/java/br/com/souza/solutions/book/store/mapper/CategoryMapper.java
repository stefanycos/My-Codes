package br.com.souza.solutions.book.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.book.store.controller.dto.CategoryDTO;
import br.com.souza.solutions.book.store.models.Category;

@Component
public class CategoryMapper {

	@Autowired
	private ModelMapper mapper;
	
	public Category toCategory(CategoryDTO categoryDTO){
		return mapper.map(categoryDTO, Category.class);
	}
}
