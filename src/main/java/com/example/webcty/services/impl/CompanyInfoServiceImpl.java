package com.example.webcty.services.impl;

import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.repositories.CompanyInfoRepository;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    @Override
    public List<CompanyInfo> getAllCompanyInfo() {
        return companyInfoRepository.findAll();
    }

    @Override
    public CompanyInfo getCompanyInfoById(Long id) {
        return companyInfoRepository.findById(id).orElse(null);
    }

    @Override
    public CompanyInfo createCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    @Override
    public CompanyInfo updateCompanyInfo(Long id, CompanyInfo updatedCompanyInfo) {
        CompanyInfo companyInfo = getCompanyInfoById(id);
        companyInfo.setSiteName(updatedCompanyInfo.getSiteName());
        companyInfo.setSiteDescription(updatedCompanyInfo.getSiteDescription());
        companyInfo.setContactEmail(updatedCompanyInfo.getContactEmail());
        companyInfo.setContactPhone(updatedCompanyInfo.getContactPhone());
        companyInfo.setContactAddress(updatedCompanyInfo.getContactAddress());
        companyInfo.setWorkingHours(updatedCompanyInfo.getWorkingHours());
        companyInfo.setMapEmbedUrl(updatedCompanyInfo.getMapEmbedUrl());
        return companyInfoRepository.save(companyInfo);
    }

    @Override
    public void deleteCompanyInfo(Long id) {
        companyInfoRepository.deleteById(id);
    }
}
