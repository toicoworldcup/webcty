package com.example.webcty.services;

import com.example.webcty.entities.CompanyHistory;
import com.example.webcty.repositories.CompanyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyHistoryService {
    @Autowired
    private CompanyHistoryRepository companyHistoryRepository;

    public List<CompanyHistory> getAllCompanyHistory() {
        return companyHistoryRepository.findAll();
    }

    public CompanyHistory getCompanyHistoryById(Long id) {
        return companyHistoryRepository.findById(id).orElse(null);
    }

    public CompanyHistory createCompanyHistory(CompanyHistory companyHistory) {
        return companyHistoryRepository.save(companyHistory);
    }

    public CompanyHistory updateCompanyHistory(Long id, CompanyHistory updatedCompanyHistory) {
        CompanyHistory companyHistory = getCompanyHistoryById(id);
        companyHistory.setTitle(updatedCompanyHistory.getTitle());
        companyHistory.setYear(updatedCompanyHistory.getYear());
        companyHistory.setDescription(updatedCompanyHistory.getDescription());
        companyHistory.setOrderIndex(updatedCompanyHistory.getOrderIndex());
        return companyHistoryRepository.save(companyHistory);
    }

    public void deleteCompanyHistory(Long id) {
        companyHistoryRepository.deleteById(id);
    }
}
