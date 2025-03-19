package com.example.webcty.services;

import com.example.webcty.entities.CompanyDetail;

import java.util.List;

public interface CompanyDetailService {
    List<CompanyDetail> getAllCompanyDetails();

    CompanyDetail getCompanyDetailById(Long id);

    CompanyDetail createCompanyDetail(CompanyDetail companyDetail);

    CompanyDetail updateCompanyDetail(Long id, CompanyDetail updatedCompanyDetail);

    void deleteCompanyDetail(Long id);
}
