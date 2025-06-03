package com.example.webcty.mapper;

import com.example.webcty.dto.request.ProjectBannerRequest;
import com.example.webcty.dto.response.ProjectBannerResponse;
import com.example.webcty.entities.projectPage.ProjectBanner;
import org.springframework.stereotype.Component;

@Component
public class ProjectBannerMapper {
    public ProjectBanner toEntity(ProjectBannerRequest dto) {
        ProjectBanner projectBanner = new ProjectBanner();
        projectBanner.setSlogan(dto.getSlogan());
        projectBanner.setImage(dto.getImage());
        return projectBanner;
    }

    public ProjectBannerResponse toResponseDTO(ProjectBanner entity) {
        ProjectBannerResponse dto = new ProjectBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImage(entity.getImage());
        return dto;
    }
}