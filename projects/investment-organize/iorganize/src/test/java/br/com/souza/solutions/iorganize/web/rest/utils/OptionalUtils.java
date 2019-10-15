package br.com.souza.solutions.iorganize.web.rest.utils;

import java.util.Optional;

public class OptionalUtils<T> {

	public Optional<T> createOptionalObject(T object) {
		return Optional.of(object);
	}
	
	public Optional<T> createEmptyOptionalObject() {
		return Optional.empty();
	}

}
