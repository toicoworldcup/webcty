package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import org.springframework.stereotype.Component;

@Component
public class CompanyManagerComponentMapper {
    public CompanyManagerComponent toEntity(CompanyManagerComponentRequest dto) {
        CompanyManagerComponent companyManagerComponent = new CompanyManagerComponent();
        companyManagerComponent.setName(dto.getName());
        companyManagerComponent.setPosition(dto.getPosition());
        companyManagerComponent.setDescription(dto.getDescription());
        companyManagerComponent.setImage(dto.getImage());
        companyManagerComponent.setOrderIndex(dto.getOrderIndex());
        return companyManagerComponent;
    }

    public CompanyManagerComponentResponse toResponseDTO(CompanyManagerComponent entity) {
        CompanyManagerComponentResponse dto = new CompanyManagerComponentResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPosition(entity.getPosition());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setOrderIndex(entity.getOrderIndex());
        return dto;
    }
}