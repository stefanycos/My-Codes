package br.com.souza.solutions.iorganize.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.souza.solutions.iorganize.models.auth.User;
import br.com.souza.solutions.iorganize.service.auth.UserService;

public class AuthTokenFilter extends OncePerRequestFilter {
	
	private JwtTokenProvider jwtTokenProvider;
	private UserService userService;
	
	public AuthTokenFilter(JwtTokenProvider jwtTokenProvider, UserService userService) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		boolean isValid = jwtTokenProvider.isTokenValid(token);
		if (isValid) {
			authUser(token);
		}
		chain.doFilter(request, response);
	}

	private void authUser(String token) {
		Long id = jwtTokenProvider.getIdUser(token);
		User user = userService.findById(id).orElse(null);
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
