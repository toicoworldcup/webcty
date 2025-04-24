package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyDetailRequest;
import com.example.webcty.dto.response.CompanyDetailResponse;
import com.example.webcty.entities.CompanyDetail;
import org.springframework.stereotype.Component;

@Component
public class CompanyDetailMapper {
    public CompanyDetail toEntity(CompanyDetailRequest dto) {
        CompanyDetail companyDetail = new CompanyDetail();
        companyDetail.setTitle(dto.getTitle());
        companyDetail.setDescription(dto.getDescription());
        companyDetail.setCreatedBy("admin"); // Mặc định created_by là admin
        return companyDetail;
    }

    public CompanyDetailResponse toResponseDTO(CompanyDetail entity) {
        CompanyDetailResponse dto = new CompanyDetailResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}