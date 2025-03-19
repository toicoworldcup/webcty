package com.example.webcty.services;

import com.example.webcty.entities.CompanyHistory;

import java.util.List;

public interface CompanyHistoryService {
    List<CompanyHistory> getAllCompanyHistory();

    CompanyHistory getCompanyHistoryById(Long id);

    CompanyHistory createCompanyHistory(CompanyHistory companyHistory);

    CompanyHistory updateCompanyHistory(Long id, CompanyHistory updatedCompanyHistory);

    void deleteCompanyHistory(Long id);
}
