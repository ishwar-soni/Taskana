package com.upgrad.taskana.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.upgrad.taskana.annotations.Employee;

import lombok.Data;

@Data
public class TaskDTO {
	private long id;

	@NotBlank
	@Size(min = 5, max = 15, message = "Title should be of size 5 to 15.")
	private String title;
	
	@NotBlank
	@Size(min = 5, message = "Description should be of size 5 to infinity.")
	private String description;
	
	@NotBlank
	@Employee
	private String assignedTo;
	
	@NotBlank
	@Employee
	private String assignedBy;
	
	@NotBlank
	private String status;
	
	@Pattern(regexp = "[\\d]{4}[/][\\d]{2}[/][\\d]{2}", message = "Date should be of format YYYY/MM/DD")
	private String assignedOn;
	
	@Pattern(regexp = "[\\d]{4}[/][\\d]{2}[/][\\d]{2}", message = "Date should be of format YYYY/MM/DD")
	private String deadline;
}
