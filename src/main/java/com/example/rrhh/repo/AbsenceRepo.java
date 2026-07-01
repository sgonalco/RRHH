package com.example.rrhh.repo;

import com.example.rrhh.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Integer> {
}
