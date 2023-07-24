package com.IT.environment.dto;

import com.IT.environment.entity.Employee;
import com.IT.environment.enums.ProjectStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private String title;
    private String attachments;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deadline;
    private ProjectStatus status;
    private String description;
    private Integer manager_id;
    private Integer assistantOfManager_id;
}
