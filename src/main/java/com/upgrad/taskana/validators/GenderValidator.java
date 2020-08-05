package com.upgrad.taskana.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.upgrad.taskana.annotations.Gender;

public class GenderValidator implements ConstraintValidator<Gender, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.equals("Male") || value.equals("Female") || value.equals("Other");
	}

}
