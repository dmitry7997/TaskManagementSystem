package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.CreateTaskDto;
import com.app.TaskManagementSystem.dto.TaskDto;
import com.app.TaskManagementSystem.dto.UserTaskDto;
import com.app.TaskManagementSystem.entity.Task;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T20:52:08+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        if ( task.getId() != null ) {
            taskDto.setId( task.getId() );
        }
        taskDto.setTaskName( task.getTaskName() );
        taskDto.setTaskPriority( task.getTaskPriority() );
        taskDto.setAuthor( task.getAuthor() );
        taskDto.setContractor( task.getContractor() );

        return taskDto;
    }

    @Override
    public Task toTask(CreateTaskDto createTaskDto) {
        if ( createTaskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setTaskName( createTaskDto.getTaskName() );
        task.setTaskPriority( createTaskDto.getTaskPriority() );
        task.setAuthor( createTaskDto.getAuthor() );
        task.setContractor( createTaskDto.getContractor() );

        return task;
    }

    @Override
    public List<UserTaskDto> toUserTaskDtoList(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<UserTaskDto> list = new ArrayList<UserTaskDto>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( taskToUserTaskDto( task ) );
        }

        return list;
    }

    protected UserTaskDto taskToUserTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        UserTaskDto userTaskDto = new UserTaskDto();

        userTaskDto.setTaskName( task.getTaskName() );

        return userTaskDto;
    }
}
