package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyPartnerRequest;
import com.example.webcty.dto.response.CompanyPartnerResponse;
import com.example.webcty.entities.CompanyPartner;
import com.example.webcty.mapper.BannerMapper;
import com.example.webcty.mapper.CompanyPartnerMapper;
import com.example.webcty.repositories.CompanyPartnerRepository;
import com.example.webcty.services.CompanyPartnerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyPartnerServiceImpl implements CompanyPartnerService {
    private final CompanyPartnerRepository companyPartnerRepository;
    private final CompanyPartnerMapper companyPartnerMapper;

    @Autowired
    public CompanyPartnerServiceImpl(CompanyPartnerRepository companyPartnerRepository, CompanyPartnerMapper companyPartnerMapper) {
        this.companyPartnerRepository = companyPartnerRepository;
        this.companyPartnerMapper = companyPartnerMapper;
    }

    @Override
    public List<CompanyPartnerResponse> getAllCompanyPartners() {
        return companyPartnerRepository.findAll().stream()
                .map(companyPartnerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyPartnerResponse getCompanyPartnerById(Long id) {
        CompanyPartner companyPartner = companyPartnerRepository.findById(id).orElse(null);
        return companyPartner != null ? companyPartnerMapper.toResponseDTO(companyPartner) : null;
    }

    @Override
    @Transactional
    public CompanyPartnerResponse createCompanyPartner(CompanyPartnerRequest companyPartnerDTO) {
        CompanyPartner companyPartner = companyPartnerMapper.toEntity(companyPartnerDTO);
        CompanyPartner savedCompanyPartner = companyPartnerRepository.save(companyPartner);
        return companyPartnerMapper.toResponseDTO(savedCompanyPartner);
    }

    @Override
    public CompanyPartnerResponse updateCompanyPartner(Long id, CompanyPartnerRequest updatedCompanyPartnerDTO) {
        CompanyPartner companyPartner = companyPartnerRepository.findById(id).orElse(null);
        if (companyPartner != null) {
            companyPartner.setLogo(updatedCompanyPartnerDTO.getLogo());
            companyPartner.setName(updatedCompanyPartnerDTO.getName());
            CompanyPartner updatedCompanyPartner = companyPartnerRepository.save(companyPartner);
            return companyPartnerMapper.toResponseDTO(updatedCompanyPartner);
        }
        return null;
    }

    @Override
    public void deleteCompanyPartner(Long id) {
        companyPartnerRepository.deleteById(id);
    }
}
