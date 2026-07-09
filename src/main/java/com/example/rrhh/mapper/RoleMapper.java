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

    public Role toEntity(RoleDto dto) {
        if (dto == null) return null;

        Role role = new Role();
        role.setId(dto.getId());
        role.setTitle(dto.getTitle());

        return role;
    }
}
