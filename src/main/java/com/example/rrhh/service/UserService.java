package com.example.rrhh.service;

import com.example.rrhh.dto.UserDto;
import com.example.rrhh.mapper.UserMapper;
import com.example.rrhh.model.Role;
import com.example.rrhh.model.User;
import com.example.rrhh.repo.RoleRepo;
import com.example.rrhh.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto findById(Integer id) {
        return userMapper.toDto(userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepo.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    public UserDto findByEmail(String email) {
        return userMapper.toDto(userRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    public UserDto save(UserDto userDto) {

        // create new user object with new dto attributes
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // map entity roles to integer ids
        Set<Role> roles = userDto.getRoleIds()
                .stream()
                .map(roleRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        // set and save roles in db
        user.setRoles(roles);
        User savedUser = userRepo.save(user);

        // Convert back to DTO
        UserDto result = new UserDto();

        result.setId(savedUser.getId());
        result.setUsername(savedUser.getUsername());
        result.setEmail(savedUser.getEmail());
        result.setCreatedAt(savedUser.getCreatedAt());
        result.setUpdatedAt(savedUser.getUpdatedAt());

        result.setRoleIds(
                savedUser.getRoles()
                        .stream()
                        .map(Role::getId)
                        .collect(Collectors.toSet())
        );

        if (savedUser.getEmployee() != null) {
            result.setEmployeeId(savedUser.getEmployee().getId());
        }

        return result;
    }

}
