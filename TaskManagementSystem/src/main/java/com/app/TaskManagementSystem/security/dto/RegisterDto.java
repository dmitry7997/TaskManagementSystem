package com.app.TaskManagementSystem.security.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private Integer roleDataId;
}
