package com.example.webcty.mapper;

import com.example.webcty.dto.request.HomeIntroRequest;
import com.example.webcty.dto.response.HomeIntroResponse;
import com.example.webcty.entities.HomeIntro;
import org.springframework.stereotype.Component;

@Component
public class HomeIntroMapper {
    public HomeIntro toEntity(HomeIntroRequest dto) {
        HomeIntro homeIntro = new HomeIntro();
        homeIntro.setTitle(dto.getTitle());
        homeIntro.setDescription(dto.getDescription());
        homeIntro.setImage(dto.getImage());
        homeIntro.setCreatedBy("admin"); // Mặc định created_by là admin
        return homeIntro;
    }

    public HomeIntroResponse toResponseDTO(HomeIntro entity) {
        HomeIntroResponse dto = new HomeIntroResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}