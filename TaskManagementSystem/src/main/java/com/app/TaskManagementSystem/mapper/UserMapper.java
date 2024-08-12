package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.UserDto;
import com.app.TaskManagementSystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
