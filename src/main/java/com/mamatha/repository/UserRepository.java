package com.mamatha.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mamatha.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	
	}

