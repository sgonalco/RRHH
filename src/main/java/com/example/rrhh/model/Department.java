package com.example.rrhh.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull // cambiar a relacion (clave foranea)
    @Column(name = "manager_id", nullable = false)
    private Integer managerId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL
    )
    private Set<Project> projects = new HashSet<>();

    // agregar la relacion manytomany con empleados

    public Department() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Set<Project> getGoals() {
        return projects;
    }

    public void setGoals(Set<Project> projects) {
        this.projects = projects;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    // metodo publico de addProject a la lista de este proyecto y establecer relacion inversa
        // comprobar si el objeto project ya esta en la lista
        // en caso contrario agregar el project
        // Comprobar si el usuario del objeto proyecto no es el mismo project.getDepartment() != this y añadirlo para establecer relación inversa

    public void addProject(Project project) {

        if (project == null) {
            return;
        }

        // Only add if it isn't already present
        if (!projects.contains(project)) {
            projects.add(project);
        }

        // Synchronize the inverse side
        if (project.getDepartment() != this) {
            project.setDepartment(this);
        }
    }

    public void removeProject(Project project) {

        if (project == null) {
            return;
        }

        if (projects.remove(project)) {
            if (project.getDepartment() == this) {
                project.setDepartment(null);
            }
        }
    }

}
