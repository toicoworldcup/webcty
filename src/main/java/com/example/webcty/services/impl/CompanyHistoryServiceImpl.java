package com.example.webcty.services.impl;

import com.example.webcty.entities.CompanyHistory;
import com.example.webcty.repositories.CompanyHistoryRepository;
import com.example.webcty.services.CompanyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyHistoryServiceImpl implements CompanyHistoryService {
    @Autowired
    private CompanyHistoryRepository companyHistoryRepository;

    @Override
    public List<CompanyHistory> getAllCompanyHistory() {
        return companyHistoryRepository.findAll();
    }

    @Override
    public CompanyHistory getCompanyHistoryById(Long id) {
        return companyHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public CompanyHistory createCompanyHistory(CompanyHistory companyHistory) {
        return companyHistoryRepository.save(companyHistory);
    }

    @Override
    public CompanyHistory updateCompanyHistory(Long id, CompanyHistory updatedCompanyHistory) {
        CompanyHistory companyHistory = getCompanyHistoryById(id);
        companyHistory.setTitle(updatedCompanyHistory.getTitle());
        companyHistory.setYear(updatedCompanyHistory.getYear());
        companyHistory.setDescription(updatedCompanyHistory.getDescription());
        companyHistory.setOrderIndex(updatedCompanyHistory.getOrderIndex());
        return companyHistoryRepository.save(companyHistory);
    }

    @Override
    public void deleteCompanyHistory(Long id) {
        companyHistoryRepository.deleteById(id);
    }
}
