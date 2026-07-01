package com.example.rrhh.repo;

import com.example.rrhh.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepo extends JpaRepository<Goal, Integer> {
}
