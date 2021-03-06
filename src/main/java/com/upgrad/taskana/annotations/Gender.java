package com.upgrad.taskana.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.upgrad.taskana.validators.GenderValidator;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = GenderValidator.class)
public @interface Gender {
	String message() default "Gender should be either MALE, FEMALE or OTHER";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
