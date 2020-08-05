package com.upgrad.taskana.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.taskana.dtos.TaskDTO;
import com.upgrad.taskana.entities.Employee;
import com.upgrad.taskana.entities.Task;
import com.upgrad.taskana.exceptions.TaskNotFoundException;
import com.upgrad.taskana.repositories.EmployeeRepository;
import com.upgrad.taskana.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public List<TaskDTO> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		List<TaskDTO> taskDTOs = tasks.stream()
				.map(task -> modelMapper.map(task, TaskDTO.class))
				.collect(Collectors.toList());
		return taskDTOs;
	}

	@Override
	@Transactional
	public TaskDTO addTask(TaskDTO taskDTO) {
		Task task = modelMapper.map(taskDTO, Task.class);
		String assignedTo = task.getAssignedTo();
		Employee employee = employeeRepository.findByName(assignedTo);
		task.setEmployee(employee);
		List<Task> existingTasks = new ArrayList<>(employee.getTasks());
		employee.getTasks().add(task);
		employee = employeeRepository.save(employee);
		Task newlyAddedTask = employee.getTasks().stream()
				.filter(t -> !existingTasks.contains(t))
				.collect(Collectors.toList())
				.get(0);
		return modelMapper.map(newlyAddedTask, TaskDTO.class);
	}

	@Override
	@Transactional
	public TaskDTO getTask(long id) throws TaskNotFoundException{
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new TaskNotFoundException("Task with id " + id + " not found.");
		}
		Task task = optionalTask.get();
		return modelMapper.map(task, TaskDTO.class);
	}

	@Override
	@Transactional
	public TaskDTO updateTask(TaskDTO taskDTO) {
		Task task = modelMapper.map(taskDTO, Task.class);
		Task savedTask = taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDTO.class);
	}

	@Override
	@Transactional
	public TaskDTO deleteTask(long id) throws TaskNotFoundException {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new TaskNotFoundException("Task with id " + id + " not found.");
		}
		Task task = optionalTask.get();
		taskRepository.deleteById(id);
		return modelMapper.map(task, TaskDTO.class);
	}

}
