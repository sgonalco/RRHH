package com.example.rrhh.repo;

import com.example.rrhh.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepo extends JpaRepository<Benefit, Integer> {
}
