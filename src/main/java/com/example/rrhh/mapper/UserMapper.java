package com.example.rrhh.mapper;

import org.springframework.stereotype.Component;
import com.example.rrhh.dto.UserDto;
import com.example.rrhh.model.Role;
import com.example.rrhh.model.User;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        dto.setRoleIds(
                user.getRoles()
                        .stream()
                        .map(Role::getId)
                        .collect(Collectors.toSet())
        );

        if (user.getEmployee() != null) {
            dto.setEmployeeId(user.getEmployee().getId());
        }

        return dto;
    }
}
