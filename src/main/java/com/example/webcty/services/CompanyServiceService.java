package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyServiceRequest;
import com.example.webcty.dto.response.CompanyServiceResponse;

import java.util.List;

public interface CompanyServiceService {
    List<CompanyServiceResponse> getAllCompanyServices();

    CompanyServiceResponse getCompanyServiceById(Long id);

    CompanyServiceResponse createCompanyService(CompanyServiceRequest companyService);

    CompanyServiceResponse updateCompanyService(Long id, CompanyServiceRequest updatedCompanyService);

    void deleteCompanyService(Long id);
}
