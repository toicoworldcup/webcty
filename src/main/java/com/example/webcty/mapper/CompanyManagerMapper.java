package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyManagerRequest;
import com.example.webcty.dto.response.CompanyManagerResponse;
import com.example.webcty.entities.CompanyManager;
import org.springframework.stereotype.Component;

@Component
public class CompanyManagerMapper {
    public CompanyManager toEntity(CompanyManagerRequest dto) {
        CompanyManager companyManager = new CompanyManager();
        companyManager.setName(dto.getName());
        companyManager.setPosition(dto.getPosition());
        companyManager.setDescription(dto.getDescription());
        companyManager.setImage(dto.getImage());
        companyManager.setOrderIndex(dto.getOrderIndex());
        companyManager.setCreatedBy("admin"); // Mặc định created_by là admin
        return companyManager;
    }

    public CompanyManagerResponse toResponseDTO(CompanyManager entity) {
        CompanyManagerResponse dto = new CompanyManagerResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPosition(entity.getPosition());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }
}