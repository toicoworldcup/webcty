package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyDetailRequest;
import com.example.webcty.dto.response.CompanyDetailResponse;
import com.example.webcty.entities.CompanyDetail;
import com.example.webcty.repositories.CompanyDetailRepository;
import com.example.webcty.services.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {
    private final CompanyDetailRepository companyDetailRepository;

    @Autowired
    public CompanyDetailServiceImpl(CompanyDetailRepository companyDetailRepository) {
        this.companyDetailRepository = companyDetailRepository;
    }

    private CompanyDetailResponse convertToResponse(CompanyDetail companyDetail) {
        CompanyDetailResponse response = new CompanyDetailResponse();
        response.setId(companyDetail.getId());
        response.setTitle(companyDetail.getTitle());
        response.setContent(companyDetail.getContent());
        return response;
    }

    private CompanyDetail convertToEntity(CompanyDetailRequest request) {
        CompanyDetail companyDetail = new CompanyDetail();
        companyDetail.setTitle(request.getTitle());
        companyDetail.setContent(request.getContent());
        return companyDetail;
    }

    @Override
    public List<CompanyDetailResponse> getAllCompanyDetails() {
        return companyDetailRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public CompanyDetailResponse getCompanyDetailById(Long id) {
        return companyDetailRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("CompanyDetail not found"));
    }

    @Override
    public CompanyDetailResponse createCompanyDetail(CompanyDetailRequest request) {
        CompanyDetail newCompanyDetail = convertToEntity(request);
        CompanyDetail savedCompanyDetail = companyDetailRepository.save(newCompanyDetail);
        return convertToResponse(savedCompanyDetail);
    }

    @Override
    public CompanyDetailResponse updateCompanyDetail(Long id, CompanyDetailRequest request) {
        CompanyDetail existingCompanyDetail = companyDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompanyDetail not found"));

        existingCompanyDetail.setTitle(request.getTitle());
        existingCompanyDetail.setContent(request.getContent());

        CompanyDetail updatedCompanyDetail = companyDetailRepository.save(existingCompanyDetail);
        return convertToResponse(updatedCompanyDetail);
    }

    @Override
    public void deleteCompanyDetail(Long id) {
        if (!companyDetailRepository.existsById(id)) {
            throw new RuntimeException("CompanyDetail not found");
        }
        companyDetailRepository.deleteById(id);
    }
}