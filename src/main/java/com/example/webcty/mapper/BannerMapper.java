package com.example.webcty.mapper;

import com.example.webcty.dto.request.BannerRequest;
import com.example.webcty.dto.response.BannerResponse;
import com.example.webcty.entities.Banner;
import org.springframework.stereotype.Component;

@Component
public class BannerMapper {
    public Banner toEntity(BannerRequest dto) {
        Banner banner = new Banner();
        banner.setTitle(dto.getTitle());
        banner.setDescription(dto.getDescription());
        banner.setImageUrls(dto.getImageUrls());
        banner.setCreatedBy("admin"); // Mặc định created_by là admin
        return banner;
    }

    public BannerResponse toResponseDTO(Banner entity) {
        BannerResponse dto = new BannerResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImageUrls(entity.getImageUrls());
        return dto;
    }
}