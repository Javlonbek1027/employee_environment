package com.IT.environment.entity;

import com.IT.environment.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projects")
public class Project {
    public Project(String title, String attachments, LocalDate startDate, LocalDate endDate, LocalDate deadline, ProjectStatus status, String description, Employee manager, Employee assistantOfManager) {
        this.title = title;
        this.attachments = attachments;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.status = status;
        this.description = description;
        this.manager = manager;
        this.assistantOfManager = assistantOfManager;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String title;
    private String attachments;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deadline;
    private ProjectStatus status;
    private String description;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "assistant_of_manager")
    private Employee assistantOfManager;





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getAssistantOfManager() {
        return assistantOfManager;
    }

    public void setAssistantOfManager(Employee assistantOfManager) {
        this.assistantOfManager = assistantOfManager;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

//    Title
//    Description
//    Manager
//    Assistant of Manager

//    Included Employees/Teams
//    Tasks(Linked tasks)
//    Attachments
//    Start Date
//    End Date
//    Deadline
//    Status(Not Started, In Progress, Completed)



    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
