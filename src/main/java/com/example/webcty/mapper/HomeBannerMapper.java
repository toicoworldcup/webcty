package com.example.webcty.mapper;

import com.example.webcty.dto.request.HomeBannerRequest;
import com.example.webcty.dto.response.HomeBannerResponse;
import com.example.webcty.entities.homePage.HomeBanner;
import org.springframework.stereotype.Component;

@Component
public class HomeBannerMapper {
    public HomeBanner toEntity(HomeBannerRequest dto) {
        HomeBanner homeBanner = new HomeBanner();
        homeBanner.setSlogan(dto.getSlogan());
        homeBanner.setImageUrls(dto.getImageUrls());
        return homeBanner;
    }

    public HomeBannerResponse toResponseDTO(HomeBanner entity) {
        HomeBannerResponse dto = new HomeBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImageUrls(entity.getImageUrls());
        return dto;
    }
}