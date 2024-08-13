package com.app.TaskManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Note")
public class Note {

    @ManyToOne
    @JoinColumn(name = "Task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String note;

}
