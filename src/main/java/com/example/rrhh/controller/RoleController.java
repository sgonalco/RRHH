package com.example.rrhh.controller;

import com.example.rrhh.dto.RoleDto;
import com.example.rrhh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }

    @GetMapping("/title/{title}")
    public RoleDto getRoleByTitle(@PathVariable String title) {
        return roleService.findByTitle(title);
    }

    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteRoleById(@PathVariable Integer id) {
        roleService.deleteById(id);
    }
}
