package com.example.webcty.mapper;

import com.example.webcty.dto.request.ServiceBannerRequest;
import com.example.webcty.dto.response.ServiceBannerResponse;
import com.example.webcty.entities.servicePage.ServiceBanner;
import org.springframework.stereotype.Component;

@Component
public class ServiceBannerMapper {
    public ServiceBanner toEntity(ServiceBannerRequest dto) {
        ServiceBanner serviceBanner = new ServiceBanner();
        serviceBanner.setSlogan(dto.getSlogan());
        serviceBanner.setImage(dto.getImage());
        return serviceBanner;
    }

    public ServiceBannerResponse toResponseDTO(ServiceBanner entity) {
        ServiceBannerResponse dto = new ServiceBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImage(entity.getImage());
        return dto;
    }
}