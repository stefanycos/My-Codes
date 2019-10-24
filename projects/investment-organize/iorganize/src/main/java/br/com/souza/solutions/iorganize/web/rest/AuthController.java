package br.com.souza.solutions.iorganize.web.rest;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.souza.solutions.iorganize.security.JwtTokenProvider;
import br.com.souza.solutions.iorganize.web.rest.dto.auth.AuthAccessToken;
import br.com.souza.solutions.iorganize.web.rest.form.LoginForm;

@RestController
@RequestMapping("v1/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping
	public AuthAccessToken authenticate(@RequestBody @Valid LoginForm form) throws AuthenticationException{
		UsernamePasswordAuthenticationToken authentication = form.converter();
		
		Authentication authenticate = authManager.authenticate(authentication);
		String token = jwtTokenProvider.getToken(authenticate);
		
		return new AuthAccessToken(token);
	}

}
