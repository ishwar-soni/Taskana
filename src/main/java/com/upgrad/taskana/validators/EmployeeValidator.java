package com.upgrad.taskana.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.upgrad.taskana.annotations.Employee;
import com.upgrad.taskana.repositories.EmployeeRepository;

public class EmployeeValidator implements ConstraintValidator<Employee, String> {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		com.upgrad.taskana.entities.Employee employee = employeeRepository.findByName(value);
		return employee != null;
	}

}
