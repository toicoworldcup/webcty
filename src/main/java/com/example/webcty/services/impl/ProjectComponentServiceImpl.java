package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ProjectComponentRequest;
import com.example.webcty.dto.response.ProjectComponentResponse;
import com.example.webcty.entities.projectPage.ProjectComponent;
import com.example.webcty.mapper.ProjectComponentMapper;
import com.example.webcty.repositories.ProjectComponentRepository;
import com.example.webcty.services.ProjectComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectComponentServiceImpl implements ProjectComponentService {
    private final ProjectComponentRepository projectComponentRepository;
    private final ProjectComponentMapper projectComponentMapper;

    @Autowired
    public ProjectComponentServiceImpl(ProjectComponentRepository projectComponentRepository) {
        this.projectComponentRepository = projectComponentRepository;
        this.projectComponentMapper = new ProjectComponentMapper();
    }

    @Override
    public List<ProjectComponentResponse> getAllProjectComponent() {
        return projectComponentRepository.findAllByOrderByCreatedDateDesc().stream()
                .map(projectComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectComponentResponse getProjectComponentById(Long id) {
        ProjectComponent projectComponent = projectComponentRepository.findById(id).orElse(null);
        return projectComponent != null ? projectComponentMapper.toResponseDTO(projectComponent) : null;
    }

    @Override
    public ProjectComponentResponse createProjectComponent(ProjectComponentRequest projectComponentDTO) {
        ProjectComponent projectComponent = projectComponentMapper.toEntity(projectComponentDTO);
        ProjectComponent savedProjectComponent = projectComponentRepository.save(projectComponent);
        return projectComponentMapper.toResponseDTO(savedProjectComponent);
    }

    @Override
    public ProjectComponentResponse updateProjectComponent(Long id, ProjectComponentRequest updatedProjectComponentDTO) {
        ProjectComponent projectComponent = projectComponentRepository.findById(id).orElse(null);
        if (projectComponent != null) {
            projectComponent.setTitle(updatedProjectComponentDTO.getTitle());
            projectComponent.setDescription(updatedProjectComponentDTO.getDescription());
            projectComponent.setImage(updatedProjectComponentDTO.getImage());
            projectComponent.setContent(updatedProjectComponentDTO.getContent());
            ProjectComponent updatedProjectComponent = projectComponentRepository.save(projectComponent);
            return projectComponentMapper.toResponseDTO(updatedProjectComponent);
        }
        return null;
    }

    @Override
    public void deleteProjectComponent(Long id) {
        projectComponentRepository.deleteById(id);
    }
}
