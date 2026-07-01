package com.example.rrhh.repo;

import com.example.rrhh.model.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeductionRepo extends JpaRepository<Deduction, Integer> {
}
