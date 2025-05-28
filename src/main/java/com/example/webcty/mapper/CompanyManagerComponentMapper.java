package com.example.webcty.mapper;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;
import com.example.webcty.dto.response.CompanyManagerResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManager;
import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import com.example.webcty.repositories.CompanyManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyManagerComponentMapper {
    private final CompanyManagerRepository companyManagerRepository;
    private final CompanyManagerMapper companyManagerMapper;
    
    @Autowired
    public CompanyManagerComponentMapper(CompanyManagerRepository companyManagerRepository, CompanyManagerMapper companyManagerMapper) {
        this.companyManagerRepository = companyManagerRepository;
        this.companyManagerMapper = companyManagerMapper;
    }
    
    public CompanyManagerComponent toEntity(CompanyManagerComponentRequest dto) {
        CompanyManagerComponent companyManagerComponent = new CompanyManagerComponent();
        companyManagerComponent.setName(dto.getName());
        companyManagerComponent.setPosition(dto.getPosition());
        companyManagerComponent.setDescription(dto.getDescription());
        companyManagerComponent.setImage(dto.getImage());
        companyManagerComponent.setOrderIndex(dto.getOrderIndex());

        CompanyManager companyManager = companyManagerRepository.findById(dto.getCompanyManagerId())
                .orElseThrow(() -> new RuntimeException("CompanyManager not found"));
        companyManagerComponent.setCompanyManager(companyManager);
        
        companyManagerComponent.setCreatedBy("admin"); // Mặc định created_by là admin
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

        CompanyManager companyManager = entity.getCompanyManager();
        CompanyManagerResponse companyManagerDTO = companyManagerMapper.toResponseDTO(companyManager);
        dto.setCompanyManager(companyManagerDTO);
        return dto;
    }
}