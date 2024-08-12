package com.app.TaskManagementSystem.controller;

import com.app.TaskManagementSystem.dto.*;
import com.app.TaskManagementSystem.entity.Task;
import com.app.TaskManagementSystem.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping("user/api/tasks")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskDto createTaskDto) {
        TaskDto savedTask = taskService.createTask(createTaskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("user/api/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Integer taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping("user/api/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("user/api/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Integer taskId,
                                              @RequestBody UpdateTaskDto updatedTask) {
        TaskDto taskDto = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping("user/api/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Integer taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task was successfully deleted");
    }

    @GetMapping("user/api/tasks/linkedUserTasks/{userId}")
    public ResponseEntity<List<UserTaskDto>> getUserTask(@PathVariable Integer userId) {
        List<UserTaskDto> tasks = taskService.getUserTask(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("user/api/tasks/linkedAuthorTasks/{author}")
    public List<Task> getAuthorTask(@PathVariable String author) {
        return taskService.getAuthorTask(author);
    }

    @GetMapping("user/api/tasks/linkedContractorTasks/{contractor}")
    public List<Task> getContractorTask(@PathVariable String contractor) {
        return taskService.getContractorTask(contractor);
    }
}
