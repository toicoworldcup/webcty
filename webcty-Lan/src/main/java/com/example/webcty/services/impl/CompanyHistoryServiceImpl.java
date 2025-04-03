package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyHistoryRequest;
import com.example.webcty.dto.response.CompanyHistoryResponse;
import com.example.webcty.entities.CompanyHistory;
import com.example.webcty.repositories.CompanyHistoryRepository;
import com.example.webcty.services.CompanyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyHistoryServiceImpl implements CompanyHistoryService {
    private final CompanyHistoryRepository companyHistoryRepository;

    @Autowired
    public CompanyHistoryServiceImpl(CompanyHistoryRepository companyHistoryRepository) {
        this.companyHistoryRepository = companyHistoryRepository;
    }

    private CompanyHistoryResponse convertToResponse(CompanyHistory companyHistory) {
        CompanyHistoryResponse response = new CompanyHistoryResponse();
        response.setId(companyHistory.getId());
        response.setTitle(companyHistory.getTitle());
        response.setYear(companyHistory.getYear());
        response.setDescription(companyHistory.getDescription());
        response.setOrderIndex(companyHistory.getOrderIndex());
        return response;
    }

    private CompanyHistory convertToEntity(CompanyHistoryRequest request) {
        CompanyHistory companyHistory = new CompanyHistory();
        companyHistory.setTitle(request.getTitle());
        companyHistory.setYear(request.getYear());
        companyHistory.setDescription(request.getDescription());
        companyHistory.setOrderIndex(request.getOrderIndex());
        return companyHistory;
    }

    @Override
    public List<CompanyHistoryResponse> getAllCompanyHistory() {
        return companyHistoryRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public CompanyHistoryResponse getCompanyHistoryById(Long id) {
        return companyHistoryRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("CompanyHistory not found"));
    }

    @Override
    public CompanyHistoryResponse createCompanyHistory(CompanyHistoryRequest request) {
        CompanyHistory newCompanyHistory = convertToEntity(request);
        CompanyHistory savedCompanyHistory = companyHistoryRepository.save(newCompanyHistory);
        return convertToResponse(savedCompanyHistory);
    }

    @Override
    public CompanyHistoryResponse updateCompanyHistory(Long id, CompanyHistoryRequest request) {
        CompanyHistory existingCompanyHistory = companyHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompanyHistory not found"));

        existingCompanyHistory.setTitle(request.getTitle());
        existingCompanyHistory.setYear(request.getYear());
        existingCompanyHistory.setDescription(request.getDescription());
        existingCompanyHistory.setOrderIndex(request.getOrderIndex());

        CompanyHistory updatedCompanyHistory = companyHistoryRepository.save(existingCompanyHistory);
        return convertToResponse(updatedCompanyHistory);
    }

    @Override
    public void deleteCompanyHistory(Long id) {
        if (!companyHistoryRepository.existsById(id)) {
            throw new RuntimeException("CompanyHistory not found");
        }
        companyHistoryRepository.deleteById(id);
    }
}