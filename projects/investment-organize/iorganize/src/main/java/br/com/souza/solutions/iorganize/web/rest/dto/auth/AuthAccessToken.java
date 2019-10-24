package br.com.souza.solutions.iorganize.web.rest.dto.auth;

import lombok.Data;

@Data
public class AuthAccessToken {

	private String accessToken;

	private String tokenType = "Bearer";

	public AuthAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
