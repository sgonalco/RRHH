package com.example.rrhh.mapper;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.model.Department;
import com.example.rrhh.model.Project;
import com.example.rrhh.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department department) {
        if (department == null) return null;

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setManagerId(department.getManagerId());
        departmentDto.setCreatedAt(department.getCreatedAt());

        return departmentDto;
    }


}
