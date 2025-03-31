package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;

import java.util.List;

public interface CompanyInfoService {
    List<CompanyInfoResponse> getAllCompanyInfo();

    CompanyInfoResponse getCompanyInfoById(Long id);

    CompanyInfoResponse createCompanyInfo(CompanyInfoRequest request);

    CompanyInfoResponse updateCompanyInfo(Long id, CompanyInfoRequest request);

    void deleteCompanyInfo(Long id);
}