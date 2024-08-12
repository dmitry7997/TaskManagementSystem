package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.TaskStatusDto;
import com.app.TaskManagementSystem.entity.TaskStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T17:55:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TaskStatusMapperImpl implements TaskStatusMapper {

    @Override
    public TaskStatusDto toTaskStatusDto(TaskStatus taskStatus) {
        if ( taskStatus == null ) {
            return null;
        }

        TaskStatusDto taskStatusDto = new TaskStatusDto();

        taskStatusDto.setId( taskStatus.getId() );
        taskStatusDto.setStatus( taskStatus.getStatus() );

        return taskStatusDto;
    }

    @Override
    public TaskStatus toTaskStatus(TaskStatusDto taskStatusDto) {
        if ( taskStatusDto == null ) {
            return null;
        }

        TaskStatus taskStatus = new TaskStatus();

        taskStatus.setId( taskStatusDto.getId() );
        taskStatus.setStatus( taskStatusDto.getStatus() );

        return taskStatus;
    }
}
