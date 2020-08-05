package com.upgrad.taskana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrad.taskana.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Employee findByName(String name);
	public Employee findByCode(String code);
}
