package com.example.webcty.services;

import com.example.webcty.dto.request.CompanySupportRequest;
import com.example.webcty.dto.response.CompanySupportResponse;

import java.util.List;

public interface CompanySupportService {
    List<CompanySupportResponse> getAllCompanySupports();

    CompanySupportResponse getCompanySupportById(Long id);

    CompanySupportResponse createCompanySupport(CompanySupportRequest companySupport);

    CompanySupportResponse updateCompanySupport(Long id, CompanySupportRequest updatedCompanySupport);

    void deleteCompanySupport(Long id);
}
