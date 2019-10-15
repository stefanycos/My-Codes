package br.com.souza.solutions.iorganize.utils;

import org.junit.Before;
import org.junit.Test;

import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectPropertyUtilsTest {
	
	private Source source;
	private Destination destination;
	
	@Before
	public void setUp() {
		source = new Source("Source Name", null);
		destination = new Destination("Destination Name", "destination@email.com");
	}
	
	@Test
	public void testCopyNonNullProperties() {
		ObjectPropertyUtils.copyNonNullProperties(source, destination);
		
		assertThat(destination.getEmail()).isNotNull();
		assertThat(destination.getName()).isEqualTo(source.getName());
	}
	
	@Data
	@AllArgsConstructor
	public class Source {
		
		private String name;
		private String email;
	}
	
	@Data
	@AllArgsConstructor
	public class Destination {
		
		private String name;
		private String email;
	}

}
