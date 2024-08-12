package com.app.TaskManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Task")
public class Task {

    @ManyToOne
    @JoinColumn(name = "Task_status_id")
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column
    private String taskName;

    @Min(1)
    @Max(10)
    @NotNull
    @Column
    private Integer taskPriority;

    @Column
    private String author;

    @Column
    private String contractor;

}
