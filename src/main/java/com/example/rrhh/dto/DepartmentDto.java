package com.example.rrhh.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DepartmentDto {

    private int id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private Integer managerId;
    private Set<Integer> projectIds;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Set<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(Set<Integer> projectIds) {
        this.projectIds = projectIds;
    }
}
