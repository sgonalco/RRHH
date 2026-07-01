package com.example.rrhh.repo;

import com.example.rrhh.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Integer> {
}
