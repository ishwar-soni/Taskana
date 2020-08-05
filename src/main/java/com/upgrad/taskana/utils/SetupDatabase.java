package com.upgrad.taskana.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.upgrad.taskana.entities.Address;
import com.upgrad.taskana.entities.Employee;
import com.upgrad.taskana.entities.Task;
import com.upgrad.taskana.repositories.AddressRepository;
import com.upgrad.taskana.repositories.EmployeeRepository;
import com.upgrad.taskana.repositories.TaskRepository;

@Component
public class SetupDatabase {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		taskRepository
				.save(new Task(0, "Task 1", "This is task 1", "ishwar", "srishti", "new", "2020/07/05", "2020/07/12"));

		taskRepository
				.save(new Task(0, "Task 2", "This is task 2", "akash", "srishti", "new", "2020/07/07", "2020/07/20"));
		taskRepository
				.save(new Task(0, "Task 1", "This is task 1", "ishwar", "srishti", "new", "2020/07/05", "2020/07/12"));

		taskRepository
				.save(new Task(0, "Task 2", "This is task 2", "akash", "srishti", "new", "2020/07/07", "2020/07/20"));
		taskRepository
				.save(new Task(0, "Task 1", "This is task 1", "ishwar", "srishti", "new", "2020/07/05", "2020/07/12"));

		taskRepository
				.save(new Task(0, "Task 2", "This is task 2", "akash", "srishti", "new", "2020/07/07", "2020/07/20"));
		taskRepository
				.save(new Task(0, "Task 1", "This is task 1", "ishwar", "srishti", "new", "2020/07/05", "2020/07/12"));

		Address address1 = new Address(0, "458", "Ajmer Road", "Degana Jn", "Nagaur", "Rajasthan", "India");
		address1 = addressRepository.save(address1);
		employeeRepository.save(new Employee(0, "Ishwar", "200232", "MALE", address1));
		
		Address address2 = new Address(0, "458", "Ajmer Road", "Degana Jn", "Nagaur", "Rajasthan", "India");
		address2 = addressRepository.save(address2);
		employeeRepository.save(new Employee(0, "Ishwar", "200232", "MALE", address2));
		
		Address address3 = new Address(0, "458", "Ajmer Road", "Degana Jn", "Nagaur", "Rajasthan", "India");
		address3 = addressRepository.save(address3);
		employeeRepository.save(new Employee(0, "Ishwar", "200232", "MALE", address3));
	}
}
