package com.example.rrhh.repo;

import com.example.rrhh.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
