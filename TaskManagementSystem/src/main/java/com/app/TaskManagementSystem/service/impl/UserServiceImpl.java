package com.app.TaskManagementSystem.service.impl;

import com.app.TaskManagementSystem.dto.UserDto;
import com.app.TaskManagementSystem.entity.User;
import com.app.TaskManagementSystem.exception.ResourceNotFondException;
import com.app.TaskManagementSystem.mapper.UserMapper;
import com.app.TaskManagementSystem.repository.UserRepository;
import com.app.TaskManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFondException("User does not exist with this id : " + userId));
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> userMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Integer userId, UserDto updateUser) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFondException("User does not exist with this id: " + userId)
        );

        user.setEmail(updateUser.getEmail());

        User updateUserObj = userRepository.save(user);

        return userMapper.toUserDto(updateUserObj);
    }

    @Override
    public void deleteUser(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFondException("User does not exist with this id: " + userId)
        );

        userRepository.deleteById(userId);
    }
}