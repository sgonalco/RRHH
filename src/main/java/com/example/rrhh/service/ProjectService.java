package com.example.rrhh.service;

import com.example.rrhh.dto.ProjectDto;
import com.example.rrhh.mapper.ProjectMapper;
import com.example.rrhh.model.Project;
import com.example.rrhh.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    // aqui van todos los metodos para gestionar los crud de project asi como la asignacion de proyectos a departamento

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ProjectMapper projectMapper;

    public List<ProjectDto> findAll(){
        return projectRepo.findAll().stream()
                .map(projectMapper::toDto)
                .toList();
    }

    public ProjectDto findById(Integer id){
        return projectMapper.toDto(projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id " + id + " not found!"))
        );
    }

    public ProjectDto findByTitle(String title){
        return projectMapper.toDto(projectRepo.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Project with title " + title + " not found!"))
        );
    }

    public Project findEntityById(Integer id) {
        return projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
