package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhoWeAreComponentRequest;
import com.example.webcty.dto.response.WhoWeAreComponentResponse;
import com.example.webcty.entities.aboutUsPage.WhoWeAreComponent;
import org.springframework.stereotype.Component;

@Component
public class WhoWeAreComponentMapper {
    public WhoWeAreComponent toEntity(WhoWeAreComponentRequest dto) {
        WhoWeAreComponent whoWeAreComponent = new WhoWeAreComponent();
        whoWeAreComponent.setContent(dto.getContent());
        whoWeAreComponent.setCreatedBy("admin"); // Mặc định created_by là admin
        return whoWeAreComponent;
    }

    public WhoWeAreComponentResponse toResponseDTO(WhoWeAreComponent entity) {
        WhoWeAreComponentResponse dto = new WhoWeAreComponentResponse();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        return dto;
    }
}