package com.upgrad.taskana.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddressDTO {
	private long id;
	
	@NotBlank
	private String houseNumber;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String district;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String country;
}
