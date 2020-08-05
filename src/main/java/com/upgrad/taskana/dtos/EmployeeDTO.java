package com.upgrad.taskana.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.upgrad.taskana.annotations.Gender;

import lombok.Data;

@Data
public class EmployeeDTO {
	private long id;
	
	@NotBlank
	@Size(min = 5, max = 15, message = "Name should be at least 5 characters long and at max 15 characters long.")
	private String name;
	
	@NotBlank
	@Size(min = 6, max = 6, message = "Employee code should be 6 character long")
	private String code;
	
	@Gender
	private String gender;
	
	@Valid
	private AddressDTO address;
}
