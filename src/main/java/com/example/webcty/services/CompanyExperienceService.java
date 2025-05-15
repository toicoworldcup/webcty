package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyExperienceRequest;
import com.example.webcty.dto.response.CompanyExperienceResponse;

import java.util.List;

public interface CompanyExperienceService {
    List<CompanyExperienceResponse> getAllCompanyExperiences();

    CompanyExperienceResponse getCompanyExperienceById(Long id);

    CompanyExperienceResponse createCompanyExperience(CompanyExperienceRequest companyExperience);

    CompanyExperienceResponse updateCompanyExperience(Long id, CompanyExperienceRequest updatedCompanyExperience);

    void deleteCompanyExperience(Long id);
}
