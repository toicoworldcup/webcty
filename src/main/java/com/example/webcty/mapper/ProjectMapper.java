package com.example.webcty.mapper;

import com.example.webcty.dto.request.ProjectRequest;
import com.example.webcty.dto.response.ProjectResponse;
import com.example.webcty.entities.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project toEntity(ProjectRequest dto) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setImage(dto.getImage());
        project.setTag(dto.getTag());
        project.setCreatedBy("admin"); // Mặc định created_by là admin
        return project;
    }

    public ProjectResponse toResponseDTO(Project entity) {
        ProjectResponse dto = new ProjectResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setTag(entity.getTag());
        return dto;
    }
}