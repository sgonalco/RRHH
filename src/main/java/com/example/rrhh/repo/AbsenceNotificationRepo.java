package com.example.rrhh.repo;

import com.example.rrhh.model.AbsenceNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceNotificationRepo extends JpaRepository<AbsenceNotification, Integer> {
}
