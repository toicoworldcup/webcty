package com.example.webcty.mapper;

import com.example.webcty.dto.request.AboutUsRequest;
import com.example.webcty.dto.response.AboutUsResponse;
import com.example.webcty.entities.AboutUs;
import org.springframework.stereotype.Component;

@Component
public class AboutUsMapper {
    public AboutUs toEntity(AboutUsRequest dto) {
        AboutUs aboutUs = new AboutUs();
        aboutUs.setTitle(dto.getTitle());
        aboutUs.setDescription(dto.getDescription());
        aboutUs.setImage(dto.getImage());
        aboutUs.setCreatedBy("admin"); // Mặc định created_by là admin
        return aboutUs;
    }

    public AboutUsResponse toResponseDTO(AboutUs entity) {
        AboutUsResponse dto = new AboutUsResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}