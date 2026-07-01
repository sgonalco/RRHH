package com.example.rrhh.repo;

import com.example.rrhh.model.AbsenceNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceNotificationRepo extends JpaRepository<AbsenceNotification, Integer> {
}
