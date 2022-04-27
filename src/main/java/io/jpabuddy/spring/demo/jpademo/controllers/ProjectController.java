package io.jpabuddy.spring.demo.jpademo.controllers;

import io.jpabuddy.spring.demo.jpademo.dtos.ProjectDto;
import io.jpabuddy.spring.demo.jpademo.entities.Project;
import io.jpabuddy.spring.demo.jpademo.mappers.ProjectMapper;
import io.jpabuddy.spring.demo.jpademo.repositories.ProjectRepository;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/api/v1/project/get/{name}")
    public List<ProjectDto> findByName(@PathVariable("name") String name) {
        List<Project> projectList = projectRepository.findByName(name);
        return projectList.stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/v1/project/save")
    public ProjectDto saveProject(@RequestBody @NonNull ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        return projectMapper.projectToProjectDto(projectRepository.save(project));
    }
}
