package com.example.webcty.mapper;

import com.example.webcty.dto.request.OurPartnerComponentRequest;
import com.example.webcty.dto.response.OurPartnerComponentResponse;
import com.example.webcty.entities.homePage.OurPartnerComponent;
import org.springframework.stereotype.Component;

@Component
public class OurPartnerComponentMapper {
    public OurPartnerComponent toEntity(OurPartnerComponentRequest dto) {
        OurPartnerComponent ourPartnerComponent = new OurPartnerComponent();
        ourPartnerComponent.setLogo(dto.getLogo());
        ourPartnerComponent.setName(dto.getName());
        return ourPartnerComponent;
    }

    public OurPartnerComponentResponse toResponseDTO(OurPartnerComponent entity) {
        OurPartnerComponentResponse dto = new OurPartnerComponentResponse();
        dto.setId(entity.getId());
        dto.setLogo(entity.getLogo());
        dto.setName(entity.getName());
        return dto;
    }
}