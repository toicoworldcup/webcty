package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;
import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.mapper.BannerMapper;
import com.example.webcty.mapper.CompanyInfoMapper;
import com.example.webcty.repositories.CompanyInfoRepository;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyInfoMapper companyInfoMapper;

    @Autowired
    public CompanyInfoServiceImpl(CompanyInfoRepository companyInfoRepository, BannerMapper bannerMapper) {
        this.companyInfoRepository = companyInfoRepository;
        this.companyInfoMapper = new CompanyInfoMapper();
    }

    @Override
    public List<CompanyInfoResponse> getAllCompanyInfos() {
        return companyInfoRepository.findAll().stream()
                .map(companyInfoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyInfoResponse getCompanyInfoById(Long id) {
        CompanyInfo companyInfo = companyInfoRepository.findById(id).orElse(null);
        return companyInfo != null ? companyInfoMapper.toResponseDTO(companyInfo) : null;
    }

    @Override
    public CompanyInfoResponse createCompanyInfo(CompanyInfoRequest companyInfoDTO) {
        CompanyInfo companyInfo = companyInfoMapper.toEntity(companyInfoDTO);
        CompanyInfo savedCompanyInfo = companyInfoRepository.save(companyInfo);
        return companyInfoMapper.toResponseDTO(savedCompanyInfo);
    }

    @Override
    public CompanyInfoResponse updateCompanyInfo(Long id, CompanyInfoRequest updatedCompanyInfoDTO) {
        CompanyInfo companyInfo = companyInfoRepository.findById(id).orElse(null);
        if (companyInfo != null) {
            companyInfo.setSiteName(updatedCompanyInfoDTO.getSiteName());
            companyInfo.setSiteDescription(updatedCompanyInfoDTO.getSiteDescription());
            companyInfo.setIcon(updatedCompanyInfoDTO.getIcon());
            companyInfo.setDirector(updatedCompanyInfoDTO.getDirector());
            companyInfo.setYear(updatedCompanyInfoDTO.getYear());
            companyInfo.setContactEmail(updatedCompanyInfoDTO.getContactEmail());
            companyInfo.setContactPhone(updatedCompanyInfoDTO.getContactPhone());
            companyInfo.setContactAddress(updatedCompanyInfoDTO.getContactAddress());
            companyInfo.setWorkingHours(updatedCompanyInfoDTO.getWorkingHours());
            companyInfo.setMapUrl(updatedCompanyInfoDTO.getMapUrl());
            CompanyInfo updatedCompanyInfo = companyInfoRepository.save(companyInfo);
            return companyInfoMapper.toResponseDTO(updatedCompanyInfo);
        }
        return null;
    }

    @Override
    public void deleteCompanyInfo(Long id) {
        companyInfoRepository.deleteById(id);
    }
}
