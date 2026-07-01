package com.example.rrhh.repo;

import com.example.rrhh.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Integer> {
}
