package com.upgrad.taskana.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String houseNumber;
	private String street;
	private String city;
	private String district;
	private String state;
	private String country;
}
