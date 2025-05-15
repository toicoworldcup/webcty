package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanySupportRequest;
import com.example.webcty.dto.response.CompanySupportResponse;
import com.example.webcty.entities.CompanySupport;
import com.example.webcty.mapper.BannerMapper;
import com.example.webcty.mapper.CompanySupportMapper;
import com.example.webcty.repositories.CompanySupportRepository;
import com.example.webcty.services.CompanySupportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanySupportServiceImpl implements CompanySupportService {
    private final CompanySupportRepository companySupportRepository;
    private final CompanySupportMapper companySupportMapper;

    @Autowired
    public CompanySupportServiceImpl(CompanySupportRepository companySupportRepository, CompanySupportMapper companySupportMapper) {
        this.companySupportRepository = companySupportRepository;
        this.companySupportMapper = companySupportMapper;
    }

    @Override
    public List<CompanySupportResponse> getAllCompanySupports() {
        return companySupportRepository.findAll().stream()
                .map(companySupportMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanySupportResponse getCompanySupportById(Long id) {
        CompanySupport companySupport = companySupportRepository.findById(id).orElse(null);
        return companySupport != null ? companySupportMapper.toResponseDTO(companySupport) : null;
    }

    @Override
    @Transactional
    public CompanySupportResponse createCompanySupport(CompanySupportRequest companySupportDTO) {
        CompanySupport companySupport = companySupportMapper.toEntity(companySupportDTO);
        CompanySupport savedCompanySupport = companySupportRepository.save(companySupport);
        return companySupportMapper.toResponseDTO(savedCompanySupport);
    }

    @Override
    public CompanySupportResponse updateCompanySupport(Long id, CompanySupportRequest updatedCompanySupportDTO) {
        CompanySupport companySupport = companySupportRepository.findById(id).orElse(null);
        if (companySupport != null) {
            companySupport.setTitle(updatedCompanySupportDTO.getTitle());
            companySupport.setDescription(updatedCompanySupportDTO.getDescription());
            companySupport.setIcon(updatedCompanySupportDTO.getIcon());
            CompanySupport updatedCompanySupport = companySupportRepository.save(companySupport);
            return companySupportMapper.toResponseDTO(updatedCompanySupport);
        }
        return null;
    }

    @Override
    public void deleteCompanySupport(Long id) {
        companySupportRepository.deleteById(id);
    }
}
