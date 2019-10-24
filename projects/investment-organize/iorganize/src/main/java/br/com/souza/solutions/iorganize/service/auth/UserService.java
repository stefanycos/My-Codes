package br.com.souza.solutions.iorganize.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.iorganize.models.auth.User;
import br.com.souza.solutions.iorganize.repository.auth.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
