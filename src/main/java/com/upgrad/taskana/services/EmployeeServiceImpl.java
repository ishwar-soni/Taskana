package com.upgrad.taskana.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.taskana.dtos.EmployeeDTO;
import com.upgrad.taskana.entities.Address;
import com.upgrad.taskana.entities.Employee;
import com.upgrad.taskana.repositories.AddressRepository;
import com.upgrad.taskana.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream()
				.map(employee -> modelMapper.map(employee, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public EmployeeDTO getEmployee(long id) {
		Employee employee = employeeRepository.findById(id).get();
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	@Override
	@Transactional
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		Address savedAddress = addressRepository.save(employee.getAddress());
		employee.setAddress(savedAddress);
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDTO.class);
	}

	@Override
	@Transactional
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		Address savedAddress = addressRepository.save(employee.getAddress());
		employee.setAddress(savedAddress);
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDTO.class);
	}

	@Override
	@Transactional
	public EmployeeDTO deleteEmployee(long id) {
		Employee employee = employeeRepository.findById(id).get();
		addressRepository.deleteById(employee.getAddress().getId());
		employeeRepository.deleteById(id);
		return modelMapper.map(employee, EmployeeDTO.class);
	}
}
