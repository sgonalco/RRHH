package com.example.rrhh.repo;

import com.example.rrhh.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<UserDto,Integer> {
}
