package com.example.rrhh.mapper;

import com.example.rrhh.dto.ProjectDto;
import com.example.rrhh.model.Project;

public class ProjectMapper {
    public ProjectDto toDto(Project project) {
        if (project == null) return null;

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId(project.getId());
        projectDto.setDescription(project.getDescription());
        projectDto.setTitle(project.getTitle());
        projectDto.setStatus(project.getStatus());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());

        return projectDto;
    }
}
