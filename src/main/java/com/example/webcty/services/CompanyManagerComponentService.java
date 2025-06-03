package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;

import java.util.List;

public interface CompanyManagerComponentService {
    List<CompanyManagerComponentResponse> getAllCompanyManagerComponent();

    CompanyManagerComponentResponse getCompanyManagerComponentById(Long id);

    CompanyManagerComponentResponse createCompanyManagerComponent(CompanyManagerComponentRequest companyManagerComponent);

    CompanyManagerComponentResponse updateCompanyManagerComponent(Long id, CompanyManagerComponentRequest updatedCompanyManagerComponent);

    void deleteCompanyManagerComponent(Long id);

    void reorderCompanyManagerComponent(List<ReorderRequest> reorderList);
}
