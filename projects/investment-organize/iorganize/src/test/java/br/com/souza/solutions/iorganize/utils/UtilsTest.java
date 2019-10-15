package br.com.souza.solutions.iorganize.utils;

import org.junit.Test;

import br.com.souza.solutions.iorganize.commons.Constants;
import br.com.souza.solutions.iorganize.utils.Utils;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

	@Test
	public void givenAnTrueBoolean_ThenReturnItsCorrespondentText() {
		String description = Utils.getStatusDescription(true);
		assertThat(description).isNotEmpty().asString().contains(Constants.ACTIVE);
	}
	
	@Test
	public void givenAnFalseBoolean_thenReturnItsCorrespondentText() {
		String description = Utils.getStatusDescription(false);
		assertThat(description).isNotEmpty().asString().contains(Constants.INACTIVE);
	}
	
	@Test
	public void givenAnString_ThenReturnTrue() {
		boolean value = Utils.getStatusValue(Constants.ACTIVE);
		assertThat(value).isTrue();
	}
	
	@Test
	public void givenAnString_ThenReturnFalse() {
		boolean value = Utils.getStatusValue(Constants.INACTIVE);
		assertThat(value).isFalse();
	}
}
