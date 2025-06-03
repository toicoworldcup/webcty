package com.example.webcty.mapper;

import com.example.webcty.dto.request.AboutUsBannerRequest;
import com.example.webcty.dto.response.AboutUsBannerResponse;
import com.example.webcty.entities.aboutUsPage.AboutUsBanner;
import org.springframework.stereotype.Component;

@Component
public class AboutUsBannerMapper {
    public AboutUsBanner toEntity(AboutUsBannerRequest dto) {
        AboutUsBanner aboutUsBanner = new AboutUsBanner();
        aboutUsBanner.setSlogan(dto.getSlogan());
        aboutUsBanner.setImage(dto.getImage());
        return aboutUsBanner;
    }

    public AboutUsBannerResponse toResponseDTO(AboutUsBanner entity) {
        AboutUsBannerResponse dto = new AboutUsBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImage(entity.getImage());
        return dto;
    }
}