package com.example.rrhh.repo;

import com.example.rrhh.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    Optional<Department> findByName(String name);
    Optional<Department> findByManagerId(Integer managerId);
}
