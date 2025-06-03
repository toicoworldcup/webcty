package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ServiceBannerRequest;
import com.example.webcty.dto.response.ServiceBannerResponse;
import com.example.webcty.entities.servicePage.ServiceBanner;
import com.example.webcty.mapper.ServiceBannerMapper;
import com.example.webcty.repositories.ServiceBannerRepository;
import com.example.webcty.services.ServiceBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceBannerServiceImpl implements ServiceBannerService {
    private final ServiceBannerRepository serviceBannerRepository;
    private final ServiceBannerMapper serviceBannerMapper;

    @Autowired
    public ServiceBannerServiceImpl(ServiceBannerRepository serviceBannerRepository, ServiceBannerMapper serviceBannerMapper) {
        this.serviceBannerRepository = serviceBannerRepository;
        this.serviceBannerMapper = serviceBannerMapper;
    }

    @Override
    public List<ServiceBannerResponse> getAllServiceBanner() {
        return serviceBannerRepository.findAll().stream()
                .map(serviceBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceBannerResponse getServiceBannerById(Long id) {
        ServiceBanner serviceBanner = serviceBannerRepository.findById(id).orElse(null);
        return serviceBanner != null ? serviceBannerMapper.toResponseDTO(serviceBanner) : null;
    }

    @Override
    @Transactional
    public ServiceBannerResponse createServiceBanner(ServiceBannerRequest serviceBannerDTO) {
        serviceBannerRepository.deleteAll();
        ServiceBanner serviceBanner = serviceBannerMapper.toEntity(serviceBannerDTO);
        ServiceBanner savedServiceBanner = serviceBannerRepository.save(serviceBanner);
        return serviceBannerMapper.toResponseDTO(savedServiceBanner);
    }

    @Override
    public ServiceBannerResponse updateServiceBanner(Long id, ServiceBannerRequest updatedServiceBannerDTO) {
        ServiceBanner serviceBanner = serviceBannerRepository.findById(id).orElse(null);
        if (serviceBanner != null) {
            serviceBanner.setSlogan(updatedServiceBannerDTO.getSlogan());
            serviceBanner.setImage(updatedServiceBannerDTO.getImage());
            ServiceBanner updatedServiceBanner = serviceBannerRepository.save(serviceBanner);
            return serviceBannerMapper.toResponseDTO(updatedServiceBanner);
        }
        return null;
    }

    @Override
    public void deleteServiceBanner(Long id) {
        serviceBannerRepository.deleteById(id);
    }
}
