package com.example.rrhh.service;

import com.example.rrhh.dto.RoleDto;
import com.example.rrhh.mapper.RoleMapper;
import com.example.rrhh.model.Role;
import com.example.rrhh.repo.RoleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleMapper roleMapper;

    public List<RoleDto> findAll() {
        return roleRepo.findAll()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }

    public RoleDto findByTitle(String title) {
        return roleMapper.toDto(roleRepo.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Role Not Found"))
        );
    }

    public RoleDto findById (Integer id) {
        return roleMapper.toDto(roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("role not found"))
        );
    }

    @Transactional
    public RoleDto save(RoleDto roleDto) {
        Role role = new Role();
        role.setTitle(roleDto.getTitle());
        return roleMapper.toDto(roleRepo.save(role));
    }

    @Transactional
    public void deleteById(Integer id) {
        roleRepo.deleteById(id);
    }

}
