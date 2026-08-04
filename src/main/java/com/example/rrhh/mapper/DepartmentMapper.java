package com.example.rrhh.mapper;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.model.Department;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department department) {
        if (department == null) return null;

        ProjectMapper projectMapper = new ProjectMapper();
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setManagerId(department.getManagerId());
        departmentDto.setCreatedAt(department.getCreatedAt());
        departmentDto.setProjects(department.getProjects()
                .stream()
                .map(p -> projectMapper.toDto(p))
                .collect(Collectors.toSet())
        );

        return departmentDto;
    }
}
