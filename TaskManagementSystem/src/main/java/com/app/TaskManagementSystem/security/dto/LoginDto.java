package com.app.TaskManagementSystem.security.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
