package com.app.TaskManagementSystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer taskStatusId;
    private int id;

    @NotBlank
    private String taskName;

    @Min(1)
    @Max(10)
    @NotNull
    private Integer taskPriority;

    @NotBlank
    private String author;

    @NotBlank
    private String contractor;

}
