package com.example.rrhh.service;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.mapper.DepartmentMapper;
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
    private ProjectRepo projectRepo;

    @Autowired
    private DepartmentMapper departmentMapper;

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

        department.setId(dto.getId());
        department.setName(dto.getName());
        department.setManagerId(dto.getManagerId());
        department.setDescription(dto.getDescription());
        department.setCreatedAt(dto.getCreatedAt());

        Set<Project> projects = dto.getProjectIds()
                .stream()
                .map(projectRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        department.setProjects(projects);
        return departmentMapper.toDto(
                departmentRepo.save(department)
        );
    }

    @Transactional
    public DepartmentDto update(DepartmentDto dto, Integer id) {

        Department existing = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        // pendiente de modificar + agregar/eliminar empleados

        return departmentMapper.toDto(
                departmentRepo.save(existing)
        );
    }

    @Transactional
    public DepartmentDto assignProject(Integer departmentId, Integer projectId) {

        Department department = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        department.getProjects().add(project);

        return departmentMapper.toDto(
                departmentRepo.save(department)
        );
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
