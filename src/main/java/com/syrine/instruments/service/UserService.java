package com.syrine.instruments.service;

import com.syrine.instruments.entities.Role;
import com.syrine.instruments.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
