package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import com.example.webcty.entities.aboutUsPage.CompanyManager;
import com.example.webcty.mapper.CompanyManagerComponentMapper;
import com.example.webcty.repositories.CompanyManagerComponentRepository;
import com.example.webcty.repositories.CompanyManagerRepository;
import com.example.webcty.services.CompanyManagerComponentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyManagerComponentServiceImpl implements CompanyManagerComponentService {
    private final CompanyManagerComponentRepository companyManagerComponentRepository;
    private final CompanyManagerComponentMapper companyManagerComponentMapper;
    private final CompanyManagerRepository companyManagerRepository;

    @Autowired
    public CompanyManagerComponentServiceImpl(CompanyManagerComponentRepository companyManagerComponentRepository, CompanyManagerComponentMapper companyManagerComponentMapper, CompanyManagerRepository companyManagerRepository) {
        this.companyManagerComponentRepository = companyManagerComponentRepository;
        this.companyManagerComponentMapper = companyManagerComponentMapper;
        this.companyManagerRepository = companyManagerRepository;
    }

    @Override
    public List<CompanyManagerComponentResponse> getAllCompanyManagerComponent() {
        return companyManagerComponentRepository.findAll().stream()
                .map(companyManagerComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyManagerComponentResponse getCompanyManagerComponentById(Long id) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentRepository.findById(id).orElse(null);
        return companyManagerComponent != null ? companyManagerComponentMapper.toResponseDTO(companyManagerComponent) : null;
    }

    @Override
    public CompanyManagerComponentResponse createCompanyManagerComponent(CompanyManagerComponentRequest companyManagerComponentDTO) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentMapper.toEntity(companyManagerComponentDTO);
        CompanyManagerComponent savedCompanyManagerComponent = companyManagerComponentRepository.save(companyManagerComponent);
        return companyManagerComponentMapper.toResponseDTO(savedCompanyManagerComponent);
    }

    @Override
    public CompanyManagerComponentResponse updateCompanyManagerComponent(Long id, CompanyManagerComponentRequest updatedCompanyManagerComponentDTO) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentRepository.findById(id).orElse(null);
        if (companyManagerComponent != null) {
            companyManagerComponent.setName(updatedCompanyManagerComponentDTO.getName());
            companyManagerComponent.setPosition(updatedCompanyManagerComponentDTO.getPosition());
            companyManagerComponent.setDescription(updatedCompanyManagerComponentDTO.getDescription());
            companyManagerComponent.setImage(updatedCompanyManagerComponentDTO.getImage());
            companyManagerComponent.setOrderIndex(updatedCompanyManagerComponentDTO.getOrderIndex());
            CompanyManager companyManager = companyManagerRepository.findById(updatedCompanyManagerComponentDTO.getCompanyManagerId())
                    .orElseThrow(() -> new RuntimeException("CompanyManager not found"));
            companyManagerComponent.setCompanyManager(companyManager);
            CompanyManagerComponent updatedCompanyManagerComponent = companyManagerComponentRepository.save(companyManagerComponent);
            return companyManagerComponentMapper.toResponseDTO(updatedCompanyManagerComponent);
        }
        return null;
    }

    @Override
    public void deleteCompanyManagerComponent(Long id) {
        companyManagerComponentRepository.deleteById(id);
    }
}
