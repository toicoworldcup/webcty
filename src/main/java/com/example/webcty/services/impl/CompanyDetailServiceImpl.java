package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyDetailRequest;
import com.example.webcty.dto.response.CompanyDetailResponse;
import com.example.webcty.entities.CompanyDetail;
import com.example.webcty.mapper.BannerMapper;
import com.example.webcty.mapper.CompanyDetailMapper;
import com.example.webcty.repositories.CompanyDetailRepository;
import com.example.webcty.services.CompanyDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyDetailServiceImpl implements CompanyDetailService {
    private final CompanyDetailRepository companyDetailRepository;
    private final CompanyDetailMapper companyDetailMapper;

    @Autowired
    public CompanyDetailServiceImpl(CompanyDetailRepository companyDetailRepository, BannerMapper bannerMapper) {
        this.companyDetailRepository = companyDetailRepository;
        this.companyDetailMapper = new CompanyDetailMapper();
    }

    @Override
    public List<CompanyDetailResponse> getAllCompanyDetails() {
        return companyDetailRepository.findAll().stream()
                .map(companyDetailMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDetailResponse getCompanyDetailById(Long id) {
        CompanyDetail companyDetail = companyDetailRepository.findById(id).orElse(null);
        return companyDetail != null ? companyDetailMapper.toResponseDTO(companyDetail) : null;
    }

    @Override
    @Transactional
    public CompanyDetailResponse createCompanyDetail(CompanyDetailRequest companyDetailDTO) {
        companyDetailRepository.deleteAll();
        CompanyDetail companyDetail = companyDetailMapper.toEntity(companyDetailDTO);
        CompanyDetail savedCompanyDetail = companyDetailRepository.save(companyDetail);
        return companyDetailMapper.toResponseDTO(savedCompanyDetail);
    }

    @Override
    public CompanyDetailResponse updateCompanyDetail(Long id, CompanyDetailRequest updatedCompanyDetailDTO) {
        CompanyDetail companyDetail = companyDetailRepository.findById(id).orElse(null);
        if (companyDetail != null) {
            companyDetail.setTitle(updatedCompanyDetailDTO.getTitle());
            companyDetail.setDescription(updatedCompanyDetailDTO.getDescription());
            CompanyDetail updatedCompanyDetail = companyDetailRepository.save(companyDetail);
            return companyDetailMapper.toResponseDTO(updatedCompanyDetail);
        }
        return null;
    }

    @Override
    public void deleteCompanyDetail(Long id) {
        companyDetailRepository.deleteById(id);
    }
}
