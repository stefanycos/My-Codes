package br.com.souza.solutions.mongodb.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.mongodb.demo.models.User;
import br.com.souza.solutions.mongodb.demo.repository.UserRepository;

@Service
public class UserService extends CrudService<User, String> {

	public UserService(UserRepository repository) {
		super(repository);
	}

	@Override
	public void save(User user) {
		if (exists(user.getName())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already registered");
		}

		super.save(user);
	}

	private boolean exists(String name) {
		Optional<User> optional = ((UserRepository) repository).findByEmailIgnoreCase(name);
		return optional.isPresent();
	}

}
