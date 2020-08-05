package com.upgrad.taskana.services;

import java.util.List;

import com.upgrad.taskana.dtos.TaskDTO;
import com.upgrad.taskana.exceptions.TaskNotFoundException;

public interface TaskService {
	public List<TaskDTO> getAllTasks();
	public TaskDTO getTask(long id) throws TaskNotFoundException;
	public TaskDTO addTask(TaskDTO taskDTO);
	public TaskDTO updateTask(TaskDTO taskDTO);
	public TaskDTO deleteTask(long id) throws TaskNotFoundException;
}
