package com.app.TaskManagementSystem.repository;

import com.app.TaskManagementSystem.entity.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDataRepository extends JpaRepository<RoleData, Integer> {
    Optional<RoleData> findByRoleName(String roleName);
}
