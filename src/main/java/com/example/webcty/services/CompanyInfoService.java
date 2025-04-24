package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;

import java.util.List;

public interface CompanyInfoService {
    List<CompanyInfoResponse> getAllCompanyInfos();

    CompanyInfoResponse getCompanyInfoById(Long id);

    CompanyInfoResponse createCompanyInfo(CompanyInfoRequest companyInfo);

    CompanyInfoResponse updateCompanyInfo(Long id, CompanyInfoRequest updatedCompanyInfo);

    void deleteCompanyInfo(Long id);
}
