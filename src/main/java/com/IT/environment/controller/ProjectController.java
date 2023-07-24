package com.IT.environment.controller;

import com.IT.environment.dto.ProjectDto;
import com.IT.environment.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/add")
    public ProjectDto addNewProject(ProjectDto projectDto){
        return projectService.addProject(projectDto);
    }
}
