package com.example.webcty.mapper;

import com.example.webcty.dto.request.OurPartnerRequest;
import com.example.webcty.dto.response.OurPartnerResponse;
import com.example.webcty.entities.homePage.OurPartner;
import org.springframework.stereotype.Component;

@Component
public class OurPartnerMapper {
    public OurPartner toEntity(OurPartnerRequest dto) {
        OurPartner ourPartner = new OurPartner();
        ourPartner.setTitle(dto.getTitle());
        ourPartner.setDescription(dto.getDescription());
        return ourPartner;
    }

    public OurPartnerResponse toResponseDTO(OurPartner entity) {
        OurPartnerResponse dto = new OurPartnerResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}