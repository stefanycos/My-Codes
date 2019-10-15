package br.com.souza.solutions.iorganize.web.rest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	private Utils() {
	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e); // NOSONAR
		}
	}

}
