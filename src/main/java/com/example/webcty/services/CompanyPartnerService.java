package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyPartnerRequest;
import com.example.webcty.dto.response.CompanyPartnerResponse;

import java.util.List;

public interface CompanyPartnerService {
    List<CompanyPartnerResponse> getAllCompanyPartners();

    CompanyPartnerResponse getCompanyPartnerById(Long id);

    CompanyPartnerResponse createCompanyPartner(CompanyPartnerRequest companyPartner);

    CompanyPartnerResponse updateCompanyPartner(Long id, CompanyPartnerRequest updatedCompanyPartner);

    void deleteCompanyPartner(Long id);
}
