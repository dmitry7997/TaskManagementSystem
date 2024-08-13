package com.app.TaskManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private Integer taskId;
    private Integer userId;
    private int id;
    private String note;
}
