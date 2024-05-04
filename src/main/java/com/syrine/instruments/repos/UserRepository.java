package com.syrine.instruments.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.syrine.instruments.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}