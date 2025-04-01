package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;
import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.repositories.CompanyInfoRepository;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    private final CompanyInfoRepository companyInfoRepository;

    @Autowired
    public CompanyInfoServiceImpl(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    private CompanyInfoResponse convertToResponse(CompanyInfo companyInfo) {
        CompanyInfoResponse response = new CompanyInfoResponse();
        response.setId(companyInfo.getId());
        response.setSiteName(companyInfo.getSiteName());
        response.setSiteDescription(companyInfo.getSiteDescription());
        response.setContactEmail(companyInfo.getContactEmail());
        response.setContactPhone(companyInfo.getContactPhone());
        response.setContactAddress(companyInfo.getContactAddress());
        response.setWorkingHours(companyInfo.getWorkingHours());
        response.setMapEmbedUrl(companyInfo.getMapEmbedUrl());
        return response;
    }

    private CompanyInfo convertToEntity(CompanyInfoRequest request) {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setSiteName(request.getSiteName());
        companyInfo.setSiteDescription(request.getSiteDescription());
        companyInfo.setContactEmail(request.getContactEmail());
        companyInfo.setContactPhone(request.getContactPhone());
        companyInfo.setContactAddress(request.getContactAddress());
        companyInfo.setWorkingHours(request.getWorkingHours());
        companyInfo.setMapEmbedUrl(request.getMapEmbedUrl());
        return companyInfo;
    }
    
    @Override
    public List<CompanyInfoResponse> getAllCompanyInfo() {
        return companyInfoRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public CompanyInfoResponse getCompanyInfoById(Long id) {
        return companyInfoRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("CompanyInfo not found"));
    }

    @Override
    public CompanyInfoResponse createCompanyInfo(CompanyInfoRequest request) {
        CompanyInfo newCompanyInfo = convertToEntity(request);
        CompanyInfo savedCompanyInfo = companyInfoRepository.save(newCompanyInfo);
        return convertToResponse(savedCompanyInfo);
    }

    @Override
    public CompanyInfoResponse updateCompanyInfo(Long id, CompanyInfoRequest request) {
        CompanyInfo existingCompanyInfo = companyInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompanyInfo not found"));

        existingCompanyInfo.setSiteName(request.getSiteName());
        existingCompanyInfo.setSiteDescription(request.getSiteDescription());
        existingCompanyInfo.setContactEmail(request.getContactEmail());
        existingCompanyInfo.setContactPhone(request.getContactPhone());
        existingCompanyInfo.setContactAddress(request.getContactAddress());
        existingCompanyInfo.setWorkingHours(request.getWorkingHours());
        existingCompanyInfo.setMapEmbedUrl(request.getMapEmbedUrl());

        CompanyInfo updatedCompanyInfo = companyInfoRepository.save(existingCompanyInfo);
        return convertToResponse(updatedCompanyInfo);
    }

    @Override
    public void deleteCompanyInfo(Long id) {
        if (!companyInfoRepository.existsById(id)) {
            throw new RuntimeException("CompanyInfo not found");
        }
        companyInfoRepository.deleteById(id);    }
}
