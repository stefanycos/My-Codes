package br.com.souza.solutions.iorganize.web.rest.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.souza.solutions.iorganize.models.auth.User;
import br.com.souza.solutions.iorganize.web.rest.dto.UserDTO;

@Component
public class UserMapper {

	public Page<UserDTO> toUserDTO(Page<User> users) {
		return users.map(UserDTO::new);
	}

}