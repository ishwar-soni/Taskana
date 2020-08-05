package com.upgrad.taskana.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.upgrad.taskana.validators.UniqueCodeValidator;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = UniqueCodeValidator.class)
public @interface UniqueCode {
	String message() default "Code already exists in database.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
