package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyServiceRequest;
import com.example.webcty.dto.response.CompanyServiceResponse;
import com.example.webcty.entities.CompanyService;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceMapper {
    public CompanyService toEntity(CompanyServiceRequest dto) {
        CompanyService companyService = new CompanyService();
        companyService.setTitle(dto.getTitle());
        companyService.setDescription(dto.getDescription());
        companyService.setImage(dto.getImage());
        companyService.setTags(dto.getTags());
        companyService.setCreatedBy("admin"); // Mặc định created_by là admin
        return companyService;
    }

    public CompanyServiceResponse toResponseDTO(CompanyService entity) {
        CompanyServiceResponse dto = new CompanyServiceResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setTags(entity.getTags());
        return dto;
    }
}