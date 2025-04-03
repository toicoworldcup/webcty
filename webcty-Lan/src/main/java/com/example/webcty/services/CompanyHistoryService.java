package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyHistoryRequest;
import com.example.webcty.dto.response.CompanyHistoryResponse;

import java.util.List;

public interface CompanyHistoryService {
    List<CompanyHistoryResponse> getAllCompanyHistory();

    CompanyHistoryResponse getCompanyHistoryById(Long id);

    CompanyHistoryResponse createCompanyHistory(CompanyHistoryRequest request);

    CompanyHistoryResponse updateCompanyHistory(Long id, CompanyHistoryRequest request);

    void deleteCompanyHistory(Long id);
}