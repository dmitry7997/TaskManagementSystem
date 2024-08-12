package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.*;
import com.app.TaskManagementSystem.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    TaskDto toTaskDto(Task task);

    Task toTask(CreateTaskDto createTaskDto);

    List<UserTaskDto> toUserTaskDtoList(List<Task> tasks);

}
