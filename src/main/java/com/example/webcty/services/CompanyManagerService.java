package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyManagerRequest;
import com.example.webcty.dto.response.CompanyManagerResponse;

import java.util.List;

public interface CompanyManagerService {
    List<CompanyManagerResponse> getAllCompanyManager();

    CompanyManagerResponse getCompanyManagerById(Long id);

    CompanyManagerResponse createCompanyManager(CompanyManagerRequest companyManager);

    CompanyManagerResponse updateCompanyManager(Long id, CompanyManagerRequest updatedCompanyManager);

    void deleteCompanyManager(Long id);
}
