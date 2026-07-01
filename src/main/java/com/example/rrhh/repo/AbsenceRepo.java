package com.example.rrhh.repo;

import com.example.rrhh.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepo extends JpaRepository<Absence, Integer> {
}
