package com.example.webcty.mapper;

import com.example.webcty.dto.request.AboutUsIntroRequest;
import com.example.webcty.dto.response.AboutUsIntroResponse;
import com.example.webcty.entities.aboutUsPage.AboutUsIntro;
import org.springframework.stereotype.Component;

@Component
public class AboutUsIntroMapper {
    public AboutUsIntro toEntity(AboutUsIntroRequest dto) {
        AboutUsIntro aboutUsIntro = new AboutUsIntro();
        aboutUsIntro.setTitle(dto.getTitle());
        aboutUsIntro.setDescription(dto.getDescription());
        aboutUsIntro.setImage(dto.getImage());
        return aboutUsIntro;
    }

    public AboutUsIntroResponse toResponseDTO(AboutUsIntro entity) {
        AboutUsIntroResponse dto = new AboutUsIntroResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}