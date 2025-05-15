package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanySupportRequest;
import com.example.webcty.dto.response.CompanySupportResponse;
import com.example.webcty.entities.CompanySupport;
import org.springframework.stereotype.Component;

@Component
public class CompanySupportMapper {
    public CompanySupport toEntity(CompanySupportRequest dto) {
        CompanySupport companySupport = new CompanySupport();
        companySupport.setTitle(dto.getTitle());
        companySupport.setDescription(dto.getDescription());
        companySupport.setIcon(dto.getIcon());
        companySupport.setCreatedBy("admin"); // Mặc định created_by là admin
        return companySupport;
    }

    public CompanySupportResponse toResponseDTO(CompanySupport entity) {
        CompanySupportResponse dto = new CompanySupportResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        return dto;
    }
}