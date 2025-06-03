package com.example.webcty.mapper;

import com.example.webcty.dto.request.NewsBannerRequest;
import com.example.webcty.dto.response.NewsBannerResponse;
import com.example.webcty.entities.newsPage.NewsBanner;
import org.springframework.stereotype.Component;

@Component
public class NewsBannerMapper {
    public NewsBanner toEntity(NewsBannerRequest dto) {
        NewsBanner newsBanner = new NewsBanner();
        newsBanner.setSlogan(dto.getSlogan());
        newsBanner.setImage(dto.getImage());
        return newsBanner;
    }

    public NewsBannerResponse toResponseDTO(NewsBanner entity) {
        NewsBannerResponse dto = new NewsBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImage(entity.getImage());
        return dto;
    }
}