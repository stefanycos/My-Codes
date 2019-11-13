package br.com.souza.solutions.iorganize.web.rest.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.souza.solutions.iorganize.models.auth.Role;
import br.com.souza.solutions.iorganize.models.auth.User;
import br.com.souza.solutions.iorganize.service.auth.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.souza.solutions.iorganize.utils.Utils.encodePassword;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
	
	@NotEmpty
	@NotNull
	private String name;

	@NotEmpty
	@NotNull
	private String email;
	
	@NotEmpty
	@NotNull
	private String password;
	
	private List<String> roleNames;
	
	private Boolean status;
	
	public User converter(RoleService roleService) {
		return User.builder()
				.email(email)
				.systemPassword(encodePassword(password))
				.roles(getRoles(roleService))
				.status(true).build();
	}
	
	public void updateReleatedEntity(User user, RoleService roleService) {
		if(!roleNames.isEmpty()) {
			user.setRoles(getRoles(roleService));
		}
	}
	
	public void updatePassword(User user) {
		if (password != null) {
			user.setSystemPassword(encodePassword(password));
		}
	}
	
	private List<Role> getRoles(RoleService roleService) {
		if (roleNames.isEmpty()) {
			return Collections.emptyList();
		}

		List<Role> roles = new ArrayList<>();
		for (String role : roleNames) {
			Role optional = roleService.findByName(role).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role named [" + role + "] not found."));

			roles.add(optional);
		}

		return roles;
	}
	
}
