package com.example.rrhh.repo;

import com.example.rrhh.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, Integer> {
}
