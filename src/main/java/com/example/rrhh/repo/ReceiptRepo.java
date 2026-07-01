package com.example.rrhh.repo;

import com.example.rrhh.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepo extends JpaRepository<Receipt, Integer> {
}
