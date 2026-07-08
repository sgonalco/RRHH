package com.example.rrhh.controller;

import com.example.rrhh.dto.RoleDto;
import com.example.rrhh.dto.UserDto;
import com.example.rrhh.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable @Positive Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/username/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestParam @Valid String username,
                         @RequestParam @Valid String password) {
        return userService.authenticateUser(username, password);
    }

    @PutMapping("/changepassword/{username}")
    public UserDto changePassword(
            @PathVariable String username,
            @RequestBody UserDto userDto) {

        return userService.changePassword(username, userDto.getPassword());
    }

    @PutMapping("/changestatus/{username}")
    public UserDto changeStatus(
            @PathVariable String username,
            @RequestBody UserDto userDto) {

        return userService.changeStatus(username, userDto.getStatus());
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto,
                              @PathVariable @Positive Integer id) {
        return userService.update(id, userDto);
    }

    @PutMapping("/assignRole/{id}")
    public UserDto assignRole(@PathVariable @Positive Integer id,
                              @RequestBody @Valid RoleDto roleDto) { // asignar cuerpo dto de rol
        return userService.assignRole(id, roleDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable @Positive Integer id) {
        userService.deleteById(id);
    }
}
