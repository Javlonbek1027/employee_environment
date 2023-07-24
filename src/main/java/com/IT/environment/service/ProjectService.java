package com.IT.environment.service;

import com.IT.environment.dto.ProjectDto;
import com.IT.environment.entity.Employee;
import com.IT.environment.entity.Project;
import com.IT.environment.repository.EmployeeRepository;
import com.IT.environment.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public ProjectDto addProject(ProjectDto projectDto) {
        projectRepository.save(DtoToEntity(projectDto));
        return projectDto;
    }

    public ProjectDto EntityToDto(Project project){
        return new ProjectDto(project.getTitle(), project.getAttachments(), project.getStartDate(),
                project.getEndDate(), project.getDeadline(), project.getStatus(), project.getDescription(),
                project.getManager().getId(), project.getAssistantOfManager().getId());
    }
    public Project DtoToEntity(ProjectDto projectDto){
        Optional<Employee> manager = employeeRepository.findById(projectDto.getManager_id());
        Optional<Employee> asistent = employeeRepository.findById(projectDto.getAssistantOfManager_id());
        return new Project(projectDto.getTitle(), projectDto.getAttachments(), projectDto.getStartDate(),
                projectDto.getEndDate(), projectDto.getDeadline(), projectDto.getStatus(), projectDto.getDescription(),
                manager.get(), asistent.get());
    }
}
