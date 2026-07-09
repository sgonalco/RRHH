package com.example.rrhh.dto;

import com.example.rrhh.model.Project;

import java.time.LocalDateTime;
import java.util.Set;

public class DepartmentDto {

    private Integer id;
    private String name;
    private LocalDateTime createdAt;
    private Integer managerId;
    private Set<ProjectDto> projects; // Enchufarle el objeto project

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Set<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDto> projects) {
        this.projects = projects;
    }
}
