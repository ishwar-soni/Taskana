package com.upgrad.taskana.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upgrad.taskana.dtos.EmployeeDTO;
import com.upgrad.taskana.services.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String getEmployees (Model model) {
		log.info("Presenting all employees");
		List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();
		log.info("total employees: " + employeeDTOs.size());
		model.addAttribute("employeeDTOs", employeeDTOs);
		return "home_employees";
	}
	
	@PostMapping("/add")
	public String addEmployee (@Valid EmployeeDTO employeeDTO, Errors errors) {
		log.info("Errors: " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "add_employees";
		}
		log.info("storing employee to database : " + employeeDTO.toString());
		employeeService.addEmployee(employeeDTO);
		return "redirect:/employees";
	}
	
	@GetMapping("/add")
	public String getAddEmployee (Model model) {
		log.info("presenting add employee form");
		EmployeeDTO employeeDTO = new EmployeeDTO();
		model.addAttribute("employeeDTO", employeeDTO);
		return "add_employees";
	}
	
	@PostMapping("/update")
	public String updateEmployee (@Valid EmployeeDTO employeeDTO, Errors errors) {
		log.info("Errors: " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "update_employee";
		}
		log.info("updating employee to database : " + employeeDTO.toString());
		employeeService.updateEmployee(employeeDTO);
		return "redirect:/employees";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateEmployee (@PathVariable long id, Model model) {
		log.info("Updating employee with id: " + id);
		try {
			EmployeeDTO employeeDTO = employeeService.getEmployee(id);
			log.info("CHECK:::::" + employeeDTO);
			model.addAttribute("employeeDTO", employeeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update_employee";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteEmployee (@PathVariable long id, Model model) {
		log.info("Deleting employee with id: " + id);
		try {
			EmployeeDTO employeeDTO = employeeService.deleteEmployee(id);
			log.info(employeeDTO.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/employees";
	}
}
