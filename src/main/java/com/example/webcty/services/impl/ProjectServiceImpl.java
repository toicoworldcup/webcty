package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ProjectRequest;
import com.example.webcty.dto.response.ProjectResponse;
import com.example.webcty.entities.projectPage.Project;
import com.example.webcty.mapper.ProjectMapper;
import com.example.webcty.repositories.ProjectRepository;
import com.example.webcty.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = new ProjectMapper();
    }

    @Override
    public List<ProjectResponse> getAllProject() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return project != null ? projectMapper.toResponseDTO(project) : null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectDTO) {
        projectRepository.deleteAll();
        Project project = projectMapper.toEntity(projectDTO);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toResponseDTO(savedProject);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest updatedProjectDTO) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setTitle(updatedProjectDTO.getTitle());
            project.setDescription(updatedProjectDTO.getDescription());
            Project updatedProject = projectRepository.save(project);
            return projectMapper.toResponseDTO(updatedProject);
        }
        return null;
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
