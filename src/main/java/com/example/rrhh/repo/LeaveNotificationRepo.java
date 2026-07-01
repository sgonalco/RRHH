package com.example.rrhh.repo;

import com.example.rrhh.model.AbsenceNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveNotificationRepo extends JpaRepository<AbsenceNotification, Integer> {
}
