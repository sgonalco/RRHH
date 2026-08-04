package com.example.rrhh.controller;

import com.example.rrhh.dto.ProjectDto;
import com.example.rrhh.service.ProjectService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    // añadir todos los endpoints para crud project + asignacion de projectos a departamentos

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDto> getProjects() {
        return projectService.findAll();
    }

    @GetMapping("/id/{projectId}")
    public ProjectDto getProjectById(@PathVariable @Positive Integer projectId) {
        return projectService.findById(projectId);
    }

    @GetMapping("/title/{projectTitle}")
    public ProjectDto getProjectByTitle(@PathVariable @Positive String projectTitle) {
        return projectService.findByTitle(projectTitle);
    }

}
