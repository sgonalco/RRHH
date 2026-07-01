package com.example.rrhh.repo;

import com.example.rrhh.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepo extends JpaRepository<Payroll, Integer> {
}
