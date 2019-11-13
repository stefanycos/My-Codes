package br.com.souza.solutions.iorganize.service.auth;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusValue;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	public Page<User> findAll(Pageable pageable, String status) {
		if (status == null) {
			return repository.findAll(pageable);
		}

		return repository.findByStatus(pageable, getStatusValue(status));
	}

	public User save(User user) {
		return repository.save(user);
	}

	public void disable(User user) {
		user.setStatus(false);
		repository.save(user);
	}
}
