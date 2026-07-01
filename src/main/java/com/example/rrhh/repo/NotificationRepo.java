package com.example.rrhh.repo;

import com.example.rrhh.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {
}
