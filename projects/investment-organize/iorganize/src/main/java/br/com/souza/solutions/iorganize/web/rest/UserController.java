package br.com.souza.solutions.iorganize.web.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.commons.Constants;
import br.com.souza.solutions.iorganize.models.auth.User;
import br.com.souza.solutions.iorganize.service.auth.RoleService;
import br.com.souza.solutions.iorganize.service.auth.UserService;
import br.com.souza.solutions.iorganize.utils.ObjectPropertyUtils;
import br.com.souza.solutions.iorganize.web.rest.dto.UserDTO;
import br.com.souza.solutions.iorganize.web.rest.form.UserForm;
import br.com.souza.solutions.iorganize.web.rest.mapper.UserMapper;

@RestController
@RequestMapping("v1/api/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private RoleService roleService;

	@GetMapping
	public Page<UserDTO> get(@RequestParam(required = false) String status, Pageable pageable) {

		Page<User> users = service.findAll(pageable, status);
		return mapper.toUserDTO(users);
	}

	@GetMapping("/{id}")
	public UserDTO get(@PathVariable Long id) {

		User user = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));
		return new UserDTO(user);
	}

	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO save(@RequestBody @Valid UserForm form) {
		User user = form.converter(roleService);
		user = service.save(user);

		return new UserDTO(user);
	}

	@PutMapping("/{id}")
	@Transactional
	public UserDTO update(@PathVariable Long id, @RequestBody UserForm form) {

		User user = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		ObjectPropertyUtils.copyNonNullProperties(form, user);
		form.updateReleatedEntity(user, roleService);
		form.updatePassword(user);
		
		return new UserDTO(user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Transactional
	public void delete(@PathVariable Long id) {

		User user = service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.NOT_FOUND_MESSAGE));

		service.disable(user);
	}

}
