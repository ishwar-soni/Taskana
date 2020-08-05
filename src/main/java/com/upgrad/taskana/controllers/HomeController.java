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

import com.upgrad.taskana.dtos.TaskDTO;
import com.upgrad.taskana.exceptions.TaskNotFoundException;
import com.upgrad.taskana.services.TaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tasks")
public class HomeController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping
	public String getTasks (Model model) {
		log.info("Presenting all tasks");
		List<TaskDTO> taskDTOs = taskService.getAllTasks();
		log.info("total tasks: " + taskDTOs.size());
		model.addAttribute("taskDTOs", taskDTOs);
		return "home_tasks";
	}
	
	@PostMapping("/add")
	public String addTask (@Valid TaskDTO task, Errors errors) {
		log.info("Errors: " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "add_tasks";
		}
		log.info("storing task to database : " + task.toString());
		taskService.addTask(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/add")
	public String getAddTask (Model model) {
		log.info("presenting add task form");
		TaskDTO taskDTO = new TaskDTO();
		model.addAttribute("taskDTO", taskDTO);
		return "add_tasks";
	}
	
	@PostMapping("/update")
	public String updateTask (@Valid TaskDTO task, Errors errors) {
		log.info("Errors: " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "update_task";
		}
		log.info("updating task to database : " + task.toString());
		taskService.updateTask(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateTask (@PathVariable long id, Model model) {
		log.info("Updating task with id: " + id);
		try {
			TaskDTO taskDTO = taskService.getTask(id);
			model.addAttribute("taskDTO", taskDTO);
		} catch (TaskNotFoundException e) {
			e.printStackTrace();
		}
		return "update_task";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTask (@PathVariable long id, Model model) {
		log.info("Deleting task with id: " + id);
		try {
			TaskDTO taskDTO = taskService.deleteTask(id);
			log.info(taskDTO.toString());
		} catch (TaskNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/tasks";
	}
	
}
