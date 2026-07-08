package com.example.rrhh.mapper;

import com.example.rrhh.dto.RoleDto;
import com.example.rrhh.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleDto toDto(Role role) {
        if (role == null) return null;

        RoleDto roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setTitle(role.getTitle());
        return roleDto;
    }
}
