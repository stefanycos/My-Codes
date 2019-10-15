package br.com.souza.solutions.iorganize.web.rest.utils;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class PagebleUtils<T> {
	
	public Page<T> getEmptyPageObject() {
		Page<T> object = new PageImpl<>(new ArrayList<>());
		return object;
	}

}
