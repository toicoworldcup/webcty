package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyDetailRequest;
import com.example.webcty.dto.response.CompanyDetailResponse;

import java.util.List;

public interface CompanyDetailService {
    List<CompanyDetailResponse> getAllCompanyDetails();

    CompanyDetailResponse getCompanyDetailById(Long id);

    CompanyDetailResponse createCompanyDetail(CompanyDetailRequest companyDetail);

    CompanyDetailResponse updateCompanyDetail(Long id, CompanyDetailRequest updatedCompanyDetail);

    void deleteCompanyDetail(Long id);
}
