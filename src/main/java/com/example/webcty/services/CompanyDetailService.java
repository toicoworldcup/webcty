package com.example.webcty.services;

import com.example.webcty.entities.CompanyDetail;
import com.example.webcty.repositories.CompanyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailService {
    @Autowired
    private CompanyDetailRepository companyDetailRepository;

    public List<CompanyDetail> getAllCompanyDetails() {
        return companyDetailRepository.findAll();
    }

    public CompanyDetail getCompanyDetailById(Long id) {
        return companyDetailRepository.findById(id).orElse(null);
    }

    public CompanyDetail createCompanyDetail(CompanyDetail companyDetail) {
        return companyDetailRepository.save(companyDetail);
    }

    public CompanyDetail updateCompanyDetail(Long id, CompanyDetail updatedCompanyDetail) {
        CompanyDetail companyDetail = getCompanyDetailById(id);
        companyDetail.setTitle(updatedCompanyDetail.getTitle());
        companyDetail.setContent(updatedCompanyDetail.getContent());
        return companyDetailRepository.save(companyDetail);
    }

    public void deleteCompanyDetail(Long id) {
        companyDetailRepository.deleteById(id);
    }
}
