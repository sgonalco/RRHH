package com.example.rrhh.repo;

import com.example.rrhh.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Optional<Project> findByTitle(String title);
}
