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

    public Project toEntity(ProjectDto projectDto) {
        if (projectDto == null) return null;

        // crear entidad de proyecto
        // settear atributos planos (hacer la transferencia atributos dto a entidad con set)
        //
        return null;
    }
}
