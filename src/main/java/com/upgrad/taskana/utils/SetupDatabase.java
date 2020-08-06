package com.upgrad.taskana.utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.upgrad.taskana.entities.Address;
import com.upgrad.taskana.entities.Employee;
import com.upgrad.taskana.entities.Task;
import com.upgrad.taskana.entities.User;
import com.upgrad.taskana.entities.UserAuthority;
import com.upgrad.taskana.repositories.AddressRepository;
import com.upgrad.taskana.repositories.EmployeeRepository;
import com.upgrad.taskana.repositories.TaskRepository;
import com.upgrad.taskana.repositories.UserAuthorityRepository;
import com.upgrad.taskana.repositories.UserRepository;

@Component
public class SetupDatabase {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Address address1 = new Address(0, "458", "Ajmer Road", "Degana Jn", "Nagaur", "Rajasthan", "India");
		address1 = addressRepository.save(address1);
		Employee emp1 = employeeRepository.save(new Employee(0, "Ishwar", "100001", "Male", address1, new ArrayList<Task>()));
		
		Address address2 = new Address(0, "123", "Ravan Gate", "Jhotwara", "Jaipur", "Rajasthan", "India");
		address2 = addressRepository.save(address2);
		employeeRepository.save(new Employee(0, "Neetu", "100002", "Female", address2, new ArrayList<Task>()));
		
		taskRepository
				.save(new Task(0, "Task 1", "This is task 1", "Ishwar", "Neetu", "NEW", "2020/07/05", "2020/07/12", emp1));
		
		userRepository.save(new User("ishwar", "$2a$10$J/4uHzfsG/3cmZB9PFaNq.qll2LPIc7jx1Vs6SnYziV6MJlsrpb7O", true));
		userRepository.save(new User("parth", "$2a$10$5ar.9YeQZaoTIP2Zw8Xp5euiNybhvNFzcnmIPOnBIrcquqg.UOpVG", true));
		
		userAuthorityRepository.save(new UserAuthority(0, "ishwar", "ROLE_USER"));
		userAuthorityRepository.save(new UserAuthority(0, "parth", "ROLE_USER"));
	}
}
