package com.example.rrhh.repo;

import com.example.rrhh.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
}
