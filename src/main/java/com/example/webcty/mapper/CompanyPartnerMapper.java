package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyPartnerRequest;
import com.example.webcty.dto.response.CompanyPartnerResponse;
import com.example.webcty.entities.CompanyPartner;
import org.springframework.stereotype.Component;

@Component
public class CompanyPartnerMapper {
    public CompanyPartner toEntity(CompanyPartnerRequest dto) {
        CompanyPartner companyPartner = new CompanyPartner();
        companyPartner.setLogo(dto.getLogo());
        companyPartner.setName(dto.getName());
        companyPartner.setCreatedBy("admin"); // Mặc định created_by là admin
        return companyPartner;
    }

    public CompanyPartnerResponse toResponseDTO(CompanyPartner entity) {
        CompanyPartnerResponse dto = new CompanyPartnerResponse();
        dto.setId(entity.getId());
        dto.setLogo(entity.getLogo());
        dto.setName(entity.getName());
        return dto;
    }
}