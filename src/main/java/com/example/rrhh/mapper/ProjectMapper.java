package com.example.rrhh.mapper;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.dto.ProjectDto;
import com.example.rrhh.model.Department;
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
        projectDto.setDepartmentId(project.getDepartment().getId());

        return projectDto;
    }

    public Project toEntity(ProjectDto projectDto, Department department) {
        if (projectDto == null) return null;

        // crear entidad de proyecto
        // settear atributos planos (hacer la transferencia atributos dto a entidad con set)

        Project project = new Project();

        project.setId(projectDto.getId());
        project.setDescription(projectDto.getDescription());
        project.setTitle(projectDto.getTitle());
        project.setStatus(projectDto.getStatus());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setDepartment(department);

        return project;
    }
}
