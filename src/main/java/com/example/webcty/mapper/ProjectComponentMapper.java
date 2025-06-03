package com.example.webcty.mapper;

import com.example.webcty.dto.request.ProjectComponentRequest;
import com.example.webcty.dto.response.ProjectComponentResponse;
import com.example.webcty.entities.projectPage.ProjectComponent;
import org.springframework.stereotype.Component;

@Component
public class ProjectComponentMapper {
    public ProjectComponent toEntity(ProjectComponentRequest dto) {
        ProjectComponent projectComponent = new ProjectComponent();
        projectComponent.setTitle(dto.getTitle());
        projectComponent.setDescription(dto.getDescription());
        projectComponent.setImage(dto.getImage());
        projectComponent.setContent(dto.getContent());
        return projectComponent;
    }

    public ProjectComponentResponse toResponseDTO(ProjectComponent entity) {
        ProjectComponentResponse dto = new ProjectComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setContent(entity.getContent());
        return dto;
    }
}