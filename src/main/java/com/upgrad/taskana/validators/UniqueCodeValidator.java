package com.upgrad.taskana.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.upgrad.taskana.annotations.UniqueCode;
import com.upgrad.taskana.entities.Employee;
import com.upgrad.taskana.repositories.EmployeeRepository;

public class UniqueCodeValidator implements ConstraintValidator<UniqueCode, String>{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Employee employee = employeeRepository.findByCode(value);
		return employee == null;
	}

}
