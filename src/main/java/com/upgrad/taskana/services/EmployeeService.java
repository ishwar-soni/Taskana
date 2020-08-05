package com.upgrad.taskana.services;

import java.util.List;

import com.upgrad.taskana.dtos.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getAllEmployees();
	public EmployeeDTO getEmployee(long id);
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO deleteEmployee(long id);
}
