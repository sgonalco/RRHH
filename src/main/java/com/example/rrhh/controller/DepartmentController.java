package com.example.rrhh.controller;

import com.example.rrhh.dto.DepartmentDto;
import com.example.rrhh.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById (@PathVariable @Positive Integer departmentId) {
        return departmentService.findById(departmentId);
    }

    @GetMapping("/name/{name}")
    public DepartmentDto getDepartmentByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }

    @GetMapping("/manager/{managerId}")
    public DepartmentDto getDepartmentByManagerId(@PathVariable @Positive Integer managerId) {
        return departmentService.findByManagerId(managerId);
    }

    @PostMapping("/createDepartment")
    public DepartmentDto createDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        return departmentService.save(departmentDto);
    }

    @PutMapping("/updateDepartment/{departmentId}")
    public DepartmentDto updateDepartment(@PathVariable @Positive Integer departmentId,
                                          @RequestBody @Valid DepartmentDto departmentDto) {
        return departmentService.update(departmentDto, departmentId);
    }

    @PutMapping("/assignProject/{departmentId}/{projectId}") // presentar como duda
    public DepartmentDto assignProject(@PathVariable @Positive Integer departmentId,
                                       @PathVariable @Positive Integer projectId) {
        return departmentService.assignProject(departmentId,projectId);
    }

    @PutMapping("/updateManager/{departmentId}/{managerId}")
    public DepartmentDto updateManager(@PathVariable @Positive Integer departmentId,
                                       @PathVariable @Positive Integer managerId){
        return departmentService.updateManager(departmentId,managerId);
    }

    @DeleteMapping("/delete")
    public void deleteDepartment(@RequestParam @Positive Integer departmentId) {
        departmentService.deleteById(departmentId);
    }
}
