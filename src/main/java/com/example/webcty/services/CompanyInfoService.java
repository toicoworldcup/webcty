package com.example.webcty.services;

import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.repositories.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoService {
    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    public List<CompanyInfo> getAllCompanyInfo() {
        return companyInfoRepository.findAll();
    }

    public CompanyInfo getCompanyInfoById(Long id) {
        return companyInfoRepository.findById(id).orElse(null);
    }

    public CompanyInfo createCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoRepository.save(companyInfo);
    }

    public CompanyInfo updateCompanyInfo(Long id, CompanyInfo updatedCompanyInfo) {
        CompanyInfo companyInfo = getCompanyInfoById(id);
        companyInfo.setSiteName(updatedCompanyInfo.getSiteName());
        companyInfo.setSiteDescription(updatedCompanyInfo.getSiteDescription());
        companyInfo.setContactEmail(updatedCompanyInfo.getContactEmail());
        companyInfo.setContactPhone(updatedCompanyInfo.getContactPhone());
        companyInfo.setContactAddress(updatedCompanyInfo.getContactAddress());
        companyInfo.setWorkingHours(updatedCompanyInfo.getWorkingHours());
        companyInfo.setMapEmbedUrl(updatedCompanyInfo.getMapEmbedUrl());
        companyInfo.setModifiedBy(updatedCompanyInfo.getModifiedBy());
        return companyInfoRepository.save(companyInfo);
    }

    public void deleteCompanyInfo(Long id) {
        companyInfoRepository.deleteById(id);
    }
}
