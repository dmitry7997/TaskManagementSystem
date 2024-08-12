package com.app.TaskManagementSystem.repository;

import com.app.TaskManagementSystem.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer> {
}
