package com.app.TaskManagementSystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDto {
    private Integer taskStatusId;

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
