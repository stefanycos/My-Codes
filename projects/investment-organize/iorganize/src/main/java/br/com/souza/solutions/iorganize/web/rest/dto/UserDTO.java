package br.com.souza.solutions.iorganize.web.rest.dto;

import static br.com.souza.solutions.iorganize.utils.Utils.getStatusDescription;

import br.com.souza.solutions.iorganize.models.auth.User;
import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String name;
	
	private String email;
	
	private String status;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.status = getStatusDescription(user.getStatus());
	}

}
