package com.example.webcty.services;

import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.repositories.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyInfoService {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    public List<CompanyInfo> getAllCompanyInfo() {
        return companyInfoRepository.findAll();
    }

    public Optional<CompanyInfo> getCompanyInfoById(Long id) {
        return companyInfoRepository.findById(id);
    }

    public CompanyInfo saveCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    public void deleteCompanyInfo(Long id) {
        companyInfoRepository.deleteById(id);
    }
}
