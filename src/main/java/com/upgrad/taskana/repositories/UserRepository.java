package com.upgrad.taskana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrad.taskana.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByUsername (String username);
}
