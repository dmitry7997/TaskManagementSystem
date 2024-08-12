package com.app.TaskManagementSystem.service;


import com.app.TaskManagementSystem.dto.*;
import com.app.TaskManagementSystem.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDto createTask (CreateTaskDto createTaskDto);

    TaskDto getTaskById(Integer taskId);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Integer taskId, UpdateTaskDto updateTask);

    void deleteTask(Integer taskId);

    List<UserTaskDto> getUserTask(Integer userId);

    List<Task> getAuthorTask(String author);

    List<Task> getContractorTask(String contractor);
}
