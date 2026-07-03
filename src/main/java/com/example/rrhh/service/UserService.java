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
        return userMapper.userToDto(savedUser);
    }

    public UserDto update(Integer id, UserDto userDto) {
        User existing = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setUsername(userDto.getUsername());
        existing.setEmail(userDto.getEmail());
        existing.setPassword(userDto.getPassword());
        existing.setCreatedAt(userDto.getCreatedAt());
        existing.setUpdatedAt(userDto.getUpdatedAt());
        existing.setUpdatedAt(LocalDateTime.now());

        Set<Role> roles = userDto.getRoleIds()
                .stream()
                .map(roleRepo::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        // set and save roles in db
        existing.setRoles(roles);

        User updatedUser = userRepo.save(existing);
        return userMapper.userToDto(updatedUser);
    }

    public void deleteByid(Integer id) {
        User user  = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
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

    public UserDto changePassword(String username, String oldPassword, String newPassword) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword);
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepo.save(user);
        return userMapper.userToDto(updatedUser);
    }

    public UserDto changeStatus(String username, String newStatus) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(newStatus);
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepo.save(user);
        return userMapper.userToDto(updatedUser);
    }
}
