package com.app.TaskManagementSystem.service.impl;

import com.app.TaskManagementSystem.dto.*;
import com.app.TaskManagementSystem.entity.*;
import com.app.TaskManagementSystem.exception.ResourceNotFondException;
import com.app.TaskManagementSystem.mapper.TaskMapper;
import com.app.TaskManagementSystem.repository.*;
import com.app.TaskManagementSystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // конструктор, использующий все final поля класса
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository; //внедряем бин через конструктор

    private final TaskMapper taskMapper;

    private final TaskStatusRepository taskStatusRepository;

    private final UserRepository userRepository;

    @Override
    public TaskDto createTask(CreateTaskDto createTaskDto) {
        Task task = taskMapper.toTask(createTaskDto);

        Integer taskStatusId = createTaskDto.getTaskStatusId();
        TaskStatus taskStatus = taskStatusRepository.findById(taskStatusId)
                .orElseThrow(() ->
                        new ResourceNotFondException("TaskStatus does not exist with this id : " + taskStatusId));
        task.setTaskStatus(taskStatus);

        Integer userId = createTaskDto.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFondException("User does not exist with this id : " + userId));
        task.setUser(user);

        Task savedTask = taskRepository.save(task);
        return taskMapper.toTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFondException("Task does not exist with this id : " + taskId));
        return taskMapper.toTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task) -> taskMapper.toTaskDto(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Integer taskId, UpdateTaskDto updateTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFondException("Task does not exist with this id: " + taskId)
        );

        task.setTaskName(updateTask.getTaskName());
        task.setTaskPriority(updateTask.getTaskPriority());
        task.setAuthor(updateTask.getAuthor());
        task.setContractor(updateTask.getContractor());

        Task updateTaskObj = taskRepository.save(task);

        return taskMapper.toTaskDto(updateTaskObj);
    }

    @Override
    public void deleteTask(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFondException("Task does not exist with this id: " + taskId)
        );

        taskRepository.deleteById(taskId);
    }

    @Override
    public List<UserTaskDto> getUserTask(Integer userId) {
        List<Task> tasks = taskRepository.findTasksByUserId(userId);

        return taskMapper.toUserTaskDtoList(tasks);
    }

    @Override
    public List<Task> getAuthorTask(String author) {
        return taskRepository.findByAuthor(author);
    }

    @Override
    public List<Task> getContractorTask(String contractor) {
        return taskRepository.findByContractor(contractor);
    }
}
