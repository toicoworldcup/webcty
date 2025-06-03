package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyManagerRequest;
import com.example.webcty.dto.response.CompanyManagerResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManager;
import org.springframework.stereotype.Component;

@Component
public class CompanyManagerMapper {
    public CompanyManager toEntity(CompanyManagerRequest dto) {
        CompanyManager companyManager = new CompanyManager();
        companyManager.setTitle(dto.getTitle());
        companyManager.setDescription(dto.getDescription());
        return companyManager;
    }

    public CompanyManagerResponse toResponseDTO(CompanyManager entity) {
        CompanyManagerResponse dto = new CompanyManagerResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}