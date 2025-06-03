package com.example.webcty.mapper;

import com.example.webcty.dto.request.HomeIntroRequest;
import com.example.webcty.dto.response.HomeIntroResponse;
import com.example.webcty.entities.homePage.HomeIntro;
import org.springframework.stereotype.Component;

@Component
public class HomeIntroMapper {
    public HomeIntro toEntity(HomeIntroRequest dto) {
        HomeIntro homeIntro = new HomeIntro();
        homeIntro.setTitle(dto.getTitle());
        homeIntro.setDescription(dto.getDescription());
        homeIntro.setContent(dto.getContent());
        homeIntro.setImage(dto.getImage());
        return homeIntro;
    }

    public HomeIntroResponse toResponseDTO(HomeIntro entity) {
        HomeIntroResponse dto = new HomeIntroResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setImage(entity.getImage());
        return dto;
    }
}