package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.TaskStatusDto;
import com.app.TaskManagementSystem.entity.TaskStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskStatusMapper {
    TaskStatusDto toTaskStatusDto(TaskStatus taskStatus);

    TaskStatus toTaskStatus(TaskStatusDto taskStatusDto);
}
