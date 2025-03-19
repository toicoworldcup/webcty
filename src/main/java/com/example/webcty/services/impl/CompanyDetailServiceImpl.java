package com.example.webcty.services.impl;

import com.example.webcty.entities.CompanyDetail;
import com.example.webcty.repositories.CompanyDetailRepository;
import com.example.webcty.services.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {
    private final CompanyDetailRepository companyDetailRepository;

    @Autowired
    public CompanyDetailServiceImpl(CompanyDetailRepository companyDetailRepository) {
        this.companyDetailRepository = companyDetailRepository;
    }

    @Override
    public List<CompanyDetail> getAllCompanyDetails() {
        return companyDetailRepository.findAll();
    }

    @Override
    public CompanyDetail getCompanyDetailById(Long id) {
        return companyDetailRepository.findById(id).orElse(null);
    }

    @Override
    public CompanyDetail createCompanyDetail(CompanyDetail companyDetail) {
        return companyDetailRepository.save(companyDetail);
    }

    @Override
    public CompanyDetail updateCompanyDetail(Long id, CompanyDetail updatedCompanyDetail) {
        CompanyDetail companyDetail = getCompanyDetailById(id);
        companyDetail.setTitle(updatedCompanyDetail.getTitle());
        companyDetail.setContent(updatedCompanyDetail.getContent());
        return companyDetailRepository.save(companyDetail);
    }

    @Override
    public void deleteCompanyDetail(Long id) {
        companyDetailRepository.deleteById(id);
    }
}
