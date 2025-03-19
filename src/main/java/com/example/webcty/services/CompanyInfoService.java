package com.example.webcty.services;

import com.example.webcty.entities.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {
    List<CompanyInfo> getAllCompanyInfo();

    CompanyInfo getCompanyInfoById(Long id);

    CompanyInfo createCompanyInfo(CompanyInfo companyInfo);

    CompanyInfo updateCompanyInfo(Long id, CompanyInfo updatedCompanyInfo);

    void deleteCompanyInfo(Long id);
}
