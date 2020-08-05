package com.upgrad.taskana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrad.taskana.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
