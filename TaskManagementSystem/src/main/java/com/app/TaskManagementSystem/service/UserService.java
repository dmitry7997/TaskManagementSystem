package com.app.TaskManagementSystem.service;

import com.app.TaskManagementSystem.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Integer userId, UserDto updateUser);

    void deleteUser(Integer userId);
}
