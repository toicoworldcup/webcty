package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;
import com.example.webcty.entities.CompanyInfo;
import org.springframework.stereotype.Component;

@Component
public class CompanyInfoMapper {
    public CompanyInfo toEntity(CompanyInfoRequest dto) {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setSiteName(dto.getSiteName());
        companyInfo.setSiteDescription(dto.getSiteDescription());
        companyInfo.setIcon(dto.getIcon());
        companyInfo.setDirector(dto.getDirector());
        companyInfo.setYear(dto.getYear());
        companyInfo.setContactEmail(dto.getContactEmail());
        companyInfo.setContactPhone(dto.getContactPhone());
        companyInfo.setContactAddress(dto.getContactAddress());
        companyInfo.setWorkingHours(dto.getWorkingHours());
        companyInfo.setMapUrl(dto.getMapUrl());
        return companyInfo;
    }

    public CompanyInfoResponse toResponseDTO(CompanyInfo entity) {
        CompanyInfoResponse dto = new CompanyInfoResponse();
        dto.setId(entity.getId());
        dto.setSiteName(entity.getSiteName());
        dto.setSiteDescription(entity.getSiteDescription());
        dto.setIcon(entity.getIcon());
        dto.setDirector(entity.getDirector());
        dto.setYear(entity.getYear());
        dto.setContactEmail(entity.getContactEmail());
        dto.setContactPhone(entity.getContactPhone());
        dto.setContactAddress(entity.getContactAddress());
        dto.setWorkingHours(entity.getWorkingHours());
        dto.setMapUrl(entity.getMapUrl());
        return dto;
    }
}