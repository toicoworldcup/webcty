package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyManagerRequest;
import com.example.webcty.dto.response.CompanyManagerResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManager;
import com.example.webcty.mapper.CompanyManagerMapper;
import com.example.webcty.repositories.CompanyManagerRepository;
import com.example.webcty.services.CompanyManagerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyManagerServiceImpl implements CompanyManagerService {
    private final CompanyManagerRepository companyManagerRepository;
    private final CompanyManagerMapper companyManagerMapper;

    @Autowired
    public CompanyManagerServiceImpl(CompanyManagerRepository companyManagerRepository, CompanyManagerMapper companyManagerMapper) {
        this.companyManagerRepository = companyManagerRepository;
        this.companyManagerMapper = companyManagerMapper;
    }

    @Override
    public List<CompanyManagerResponse> getAllCompanyManager() {
        return companyManagerRepository.findAll().stream()
                .map(companyManagerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyManagerResponse getCompanyManagerById(Long id) {
        CompanyManager companyManager = companyManagerRepository.findById(id).orElse(null);
        return companyManager != null ? companyManagerMapper.toResponseDTO(companyManager) : null;
    }

    @Override
    @Transactional
    public CompanyManagerResponse createCompanyManager(CompanyManagerRequest companyManagerDTO) {
        companyManagerRepository.deleteAll();
        CompanyManager companyManager = companyManagerMapper.toEntity(companyManagerDTO);
        CompanyManager savedCompanyManager = companyManagerRepository.save(companyManager);
        return companyManagerMapper.toResponseDTO(savedCompanyManager);
    }

    @Override
    public CompanyManagerResponse updateCompanyManager(Long id, CompanyManagerRequest updatedCompanyManagerDTO) {
        CompanyManager companyManager = companyManagerRepository.findById(id).orElse(null);
        if (companyManager != null) {
            companyManager.setTitle(updatedCompanyManagerDTO.getTitle());
            companyManager.setDescription(updatedCompanyManagerDTO.getDescription());
            CompanyManager updatedCompanyManager = companyManagerRepository.save(companyManager);
            return companyManagerMapper.toResponseDTO(updatedCompanyManager);
        }
        return null;
    }

    @Override
    public void deleteCompanyManager(Long id) {
        companyManagerRepository.deleteById(id);
    }
}
