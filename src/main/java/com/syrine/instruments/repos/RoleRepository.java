package com.syrine.instruments.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syrine.instruments.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
