package com.example.rrhh.repo;

import com.example.rrhh.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll, Integer> {
}
