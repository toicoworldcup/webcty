package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyExperienceRequest;
import com.example.webcty.dto.response.CompanyExperienceResponse;
import com.example.webcty.entities.CompanyExperience;
import com.example.webcty.mapper.CompanyExperienceMapper;
import com.example.webcty.repositories.CompanyExperienceRepository;
import com.example.webcty.services.CompanyExperienceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyExperienceServiceImpl implements CompanyExperienceService {
    private final CompanyExperienceRepository companyExperienceRepository;
    private final CompanyExperienceMapper companyExperienceMapper;

    @Autowired
    public CompanyExperienceServiceImpl(CompanyExperienceRepository companyExperienceRepository, CompanyExperienceMapper companyExperienceMapper) {
        this.companyExperienceRepository = companyExperienceRepository;
        this.companyExperienceMapper = companyExperienceMapper;
    }

    @Override
    public List<CompanyExperienceResponse> getAllCompanyExperiences() {
        return companyExperienceRepository.findAll().stream()
                .map(companyExperienceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyExperienceResponse getCompanyExperienceById(Long id) {
        CompanyExperience companyExperience = companyExperienceRepository.findById(id).orElse(null);
        return companyExperience != null ? companyExperienceMapper.toResponseDTO(companyExperience) : null;
    }

    @Override
    @Transactional
    public CompanyExperienceResponse createCompanyExperience(CompanyExperienceRequest companyExperienceDTO) {
        companyExperienceRepository.deleteAll();
        CompanyExperience companyExperience = companyExperienceMapper.toEntity(companyExperienceDTO);
        CompanyExperience savedCompanyExperience = companyExperienceRepository.save(companyExperience);
        return companyExperienceMapper.toResponseDTO(savedCompanyExperience);
    }

    @Override
    public CompanyExperienceResponse updateCompanyExperience(Long id, CompanyExperienceRequest updatedCompanyExperienceDTO) {
        CompanyExperience companyExperience = companyExperienceRepository.findById(id).orElse(null);
        if (companyExperience != null) {
            companyExperience.setTitle(updatedCompanyExperienceDTO.getTitle());
            companyExperience.setDescription(updatedCompanyExperienceDTO.getDescription());
            CompanyExperience updatedCompanyExperience = companyExperienceRepository.save(companyExperience);
            return companyExperienceMapper.toResponseDTO(updatedCompanyExperience);
        }
        return null;
    }

    @Override
    public void deleteCompanyExperience(Long id) {
        companyExperienceRepository.deleteById(id);
    }
}
