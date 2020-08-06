package com.upgrad.taskana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrad.taskana.entities.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {

}
