package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyServiceRequest;
import com.example.webcty.dto.response.CompanyServiceResponse;
import com.example.webcty.entities.CompanyService;
import com.example.webcty.mapper.CompanyServiceMapper;
import com.example.webcty.repositories.CompanyServiceRepository;
import com.example.webcty.services.CompanyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceServiceImpl implements CompanyServiceService {
    private final CompanyServiceRepository companyServiceRepository;
    private final CompanyServiceMapper companyServiceMapper;

    @Autowired
    public CompanyServiceServiceImpl(CompanyServiceRepository companyServiceRepository, CompanyServiceMapper companyServiceMapper) {
        this.companyServiceRepository = companyServiceRepository;
        this.companyServiceMapper = companyServiceMapper;
    }

    @Override
    public List<CompanyServiceResponse> getAllCompanyServices() {
        return companyServiceRepository.findAll().stream()
                .map(companyServiceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyServiceResponse getCompanyServiceById(Long id) {
        CompanyService companyService = companyServiceRepository.findById(id).orElse(null);
        return companyService != null ? companyServiceMapper.toResponseDTO(companyService) : null;
    }

    @Override
    public CompanyServiceResponse createCompanyService(CompanyServiceRequest companyServiceDTO) {
        CompanyService companyService = companyServiceMapper.toEntity(companyServiceDTO);
        CompanyService savedCompanyService = companyServiceRepository.save(companyService);
        return companyServiceMapper.toResponseDTO(savedCompanyService);
    }

    @Override
    public CompanyServiceResponse updateCompanyService(Long id, CompanyServiceRequest updatedCompanyServiceDTO) {
        CompanyService companyService = companyServiceRepository.findById(id).orElse(null);
        if (companyService != null) {
            companyService.setTitle(updatedCompanyServiceDTO.getTitle());
            companyService.setDescription(updatedCompanyServiceDTO.getDescription());
            companyService.setImage(updatedCompanyServiceDTO.getImage());
            companyService.setTags(updatedCompanyServiceDTO.getTags());
            CompanyService updatedCompanyService = companyServiceRepository.save(companyService);
            return companyServiceMapper.toResponseDTO(updatedCompanyService);
        }
        return null;
    }

    @Override
    public void deleteCompanyService(Long id) {
        companyServiceRepository.deleteById(id);
    }
}
