package com.app.TaskManagementSystem.repository;

import com.app.TaskManagementSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findTasksByUserId(Integer userId);
    List<Task> findByAuthor(String author);
    List<Task> findByContractor(String contractor);
}
