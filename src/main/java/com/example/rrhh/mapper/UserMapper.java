package com.example.rrhh.mapper;

import com.example.rrhh.dto.UserDto;
import com.example.rrhh.model.Role;
import com.example.rrhh.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto userToDto(User user) {
        if(user == null) return null;

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setStatus(user.getStatus());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());

        userDto.setRoles(
                user.getRoles().
                    stream()
                    .map(Role::getId)
                    .collect(Collectors.toSet())
        );

        return  userDto;
    }
}
