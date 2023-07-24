package com.IT.environment.entity;

import com.IT.environment.enums.task.TaskPriority;
import com.IT.environment.enums.task.TaskStatus;
import com.IT.environment.enums.task.TaskType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Tasks {

//    Title
//Description
//Task ID(auto generated)
//Assignee
//Type(Bug, feature)
//Priority(high, medium, low)
//Start Date
//End Date
//Deadline
//Estimated Time
//Spent Time
//Project(linked to project)
//Attachments
//Status Dynamic(default - Not Started, In Progress, Completed)
//Checklist
//Comments
    private String title;
    private String description;
    private TaskType type;
    private TaskPriority taskPriority;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deadline;
    private LocalDate estimatedTime;
    private LocalDate SpentTime;
    private String attachments;
    private TaskStatus status;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Employee assignee;

    @ManyToOne
    @JoinColumn(name = "projects_id")
    private Project projects;

}
