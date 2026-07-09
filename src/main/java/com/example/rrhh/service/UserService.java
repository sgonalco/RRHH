package com.example.rrhh.service;

import com.example.rrhh.dto.RoleDto;
import com.example.rrhh.dto.UserDto;
import com.example.rrhh.mapper.RoleMapper;
import com.example.rrhh.mapper.UserMapper;
import com.example.rrhh.model.Role;
import com.example.rrhh.model.User;
import com.example.rrhh.repo.RoleRepo;
import com.example.rrhh.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepo roleRepo;

    public List<UserDto> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::userToDto)
                .toList();
    }

    public UserDto findById(Integer id) {
        return userMapper.userToDto(userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    public UserDto findByUsername(String username) {
        return userMapper.userToDto(userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    public UserDto findByEmail(String email) {
        return userMapper.userToDto(userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

    @Transactional
    public UserDto save(UserDto userDto) {

        // create new user object with new dto attributes
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setStatus(userDto.getStatus());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setRoles(userDto.getRoles()
                .stream()
                .map(roleMapper::toEntity)
                .collect(Collectors.toSet())
        );
        // Convert back to DTO
        return userMapper.userToDto(userRepo.save(user));
    }

    @Transactional
    public UserDto update(Integer id, UserDto userDto) {
        User existing = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(userDto.getUsername());
        existing.setEmail(userDto.getEmail());
        existing.setPassword(userDto.getPassword());
        existing.setCreatedAt(userDto.getCreatedAt());
        existing.setUpdatedAt(userDto.getUpdatedAt());
        existing.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepo.save(existing);
        return userMapper.userToDto(updatedUser);
    }

    public UserDto authenticateUser(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(user.getPassword().equals(password)) {
            return userMapper.userToDto(user);
        }else {
            throw new RuntimeException("Wrong password");
        }
    }

    /*
    @Transactional
    public UserDto assignRole(Integer userId, RoleDto roleDto) { // pasarle dto role
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserDto userDto = userMapper.userToDto(user);
        RoleDto existingRole = roleService.findById(roleDto.getId());
        if (existingRole == null) {
            throw new RuntimeException("ROLE DOES NOT EXIST");
        }
        if(!userDto.getRoles().contains(existingRole)) {
            userDto.getRoles().add(existingRole);
        }else {
            throw new RuntimeException("USER ALREADY HAS ROLE ASSIGNED");
        }
        return userMapper.userToDto(userRepo.save(user));
    }
     */

    @Transactional
    public UserDto assignRole(Integer userId, RoleDto roleDto) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepo.findById(roleDto.getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role);
        } else {
            throw new RuntimeException("User already has role assigned");
        }

        return userMapper.userToDto(userRepo.save(user));
    }

    @Transactional
    public UserDto changePassword(String username, String newPassword) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword);
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepo.save(user);
        return userMapper.userToDto(updatedUser);
    }

    @Transactional
    public UserDto changeStatus(String username, String newStatus) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(newStatus);
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepo.save(user);
        return userMapper.userToDto(updatedUser);
    }

    @Transactional
    public void deleteById(Integer id) {
        User user  = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }
}
