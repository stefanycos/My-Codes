package br.com.souza.solutions.iorganize.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.souza.solutions.iorganize.models.auth.Role;
import br.com.souza.solutions.iorganize.repository.auth.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;

	public Optional<Role> findByName(String name) {
		return repository.findByRoleType(name);
	}
}
