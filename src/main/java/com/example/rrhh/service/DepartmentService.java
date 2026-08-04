package com.example.rrhh.service;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.dto.ProjectDto;
import com.example.rrhh.mapper.DepartmentMapper;
import com.example.rrhh.mapper.ProjectMapper;
import com.example.rrhh.model.Department;
import com.example.rrhh.model.Project;
import com.example.rrhh.repo.DepartmentRepo;
import com.example.rrhh.repo.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private ProjectMapper projectMapper;

    public List<DepartmentDto> findAll() {

        return departmentRepo.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    public DepartmentDto findById(Integer id) {

        return departmentMapper.toDto(departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"))
        );
    }

    public DepartmentDto findByName(String name) {

        return departmentMapper.toDto(departmentRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Department not found"))
        );
    }

    // pendiente por modificar: managerid es clave foranea de entidad empleado
    public DepartmentDto findByManagerId(Integer managerId){

        return departmentMapper.toDto(departmentRepo.findByManagerId(managerId)
            .orElseThrow(() -> new RuntimeException("Department not found"))
        );
    }

    /* pendiente por crear el metodo que devuelve todos los empleados de un departamento
    public List<EmployeeDto> getAllEmployees(DepartmentDto department)
     */

    @Transactional
    public DepartmentDto save(DepartmentDto dto) {

        Department department = new Department();

        department.setName(dto.getName());
        department.setManagerId(dto.getManagerId());
        department.setCreatedAt(dto.getCreatedAt());
        if (dto.getProjects() != null) {
            dto.getProjects().stream()
                    .map(p -> projectService.findEntityById(p.getId()))
                    .forEach(department::addProject);
        }

        return departmentMapper.toDto(departmentRepo.save(department));
    }

    @Transactional
    public DepartmentDto update(DepartmentDto dto, Integer id) {

        Department existing = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existing.setName(dto.getName());
        // pendiente de modificar + agregar/eliminar empleados

        return departmentMapper.toDto(
                departmentRepo.save(existing)
        );
    }

    // metodo experimental
    @Transactional
    public DepartmentDto assignProject(Integer departmentId, ProjectDto projectDto) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        ProjectDto existingProject = projectService.findById(projectDto.getId());

        Project project = projectMapper.toEntity(existingProject, department);

        if(existingProject == null) {
            throw new RuntimeException("Project not found");
        }if (!department.getProjects().contains(project)) {
            department.addProject(project);
        }else {
            throw new RuntimeException("Department already has project assigned");
        }

        return departmentMapper.toDto(departmentRepo.save(department));
    }

    @Transactional
    public DepartmentDto updateManager(Integer departmentId, Integer managerId) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setManagerId(managerId);

        return departmentMapper.toDto(
                departmentRepo.save(department)
        );
    }

    @Transactional
    public void deleteById(Integer id) {
        departmentRepo.deleteById(id);
    }
}
