package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyExperienceRequest;
import com.example.webcty.dto.response.CompanyExperienceResponse;
import com.example.webcty.entities.CompanyExperience;
import org.springframework.stereotype.Component;

@Component
public class CompanyExperienceMapper {
    public CompanyExperience toEntity(CompanyExperienceRequest dto) {
        CompanyExperience companyExperience = new CompanyExperience();
        companyExperience.setTitle(dto.getTitle());
        companyExperience.setDescription(dto.getDescription());
        companyExperience.setCreatedBy("admin"); // Mặc định created_by là admin
        return companyExperience;
    }

    public CompanyExperienceResponse toResponseDTO(CompanyExperience entity) {
        CompanyExperienceResponse dto = new CompanyExperienceResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}