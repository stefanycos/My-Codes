package br.com.souza.solutions.iorganize.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.souza.solutions.iorganize.models.auth.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
