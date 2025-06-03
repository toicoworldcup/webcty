package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhoWeAreRequest;
import com.example.webcty.dto.response.WhoWeAreResponse;
import com.example.webcty.entities.aboutUsPage.WhoWeAre;
import org.springframework.stereotype.Component;

@Component
public class WhoWeAreMapper {
    public WhoWeAre toEntity(WhoWeAreRequest dto) {
        WhoWeAre whoWeAre = new WhoWeAre();
        whoWeAre.setTitle(dto.getTitle());
        whoWeAre.setDescription(dto.getDescription());
        return whoWeAre;
    }

    public WhoWeAreResponse toResponseDTO(WhoWeAre entity) {
        WhoWeAreResponse dto = new WhoWeAreResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}