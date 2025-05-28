package com.example.webcty.mapper;

import com.example.webcty.dto.request.OurPartnerComponentRequest;
import com.example.webcty.dto.response.OurPartnerComponentResponse;
import com.example.webcty.dto.response.OurPartnerResponse;
import com.example.webcty.entities.homePage.OurPartner;
import com.example.webcty.entities.homePage.OurPartnerComponent;
import com.example.webcty.repositories.OurPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OurPartnerComponentMapper {
    private final OurPartnerRepository ourPartnerRepository;
    private final OurPartnerMapper ourPartnerMapper;

    @Autowired
    public OurPartnerComponentMapper(OurPartnerRepository ourPartnerRepository, OurPartnerMapper ourPartnerMapper) {
        this.ourPartnerRepository = ourPartnerRepository;
        this.ourPartnerMapper = ourPartnerMapper;
    }

    public OurPartnerComponent toEntity(OurPartnerComponentRequest dto) {
        OurPartnerComponent ourPartnerComponent = new OurPartnerComponent();
        ourPartnerComponent.setLogo(dto.getLogo());
        ourPartnerComponent.setName(dto.getName());

        OurPartner ourPartner = ourPartnerRepository.findById(dto.getOurPartnerId())
                .orElseThrow(() -> new RuntimeException("OurPartner not found"));
        ourPartnerComponent.setOurPartner(ourPartner);

        ourPartnerComponent.setCreatedBy("admin"); // Mặc định created_by là admin
        return ourPartnerComponent;
    }

    public OurPartnerComponentResponse toResponseDTO(OurPartnerComponent entity) {
        OurPartnerComponentResponse dto = new OurPartnerComponentResponse();
        dto.setId(entity.getId());
        dto.setLogo(entity.getLogo());
        dto.setName(entity.getName());
        OurPartner ourPartner = entity.getOurPartner();
        OurPartnerResponse ourPartnerDTO = ourPartnerMapper.toResponseDTO(ourPartner);
        dto.setOurPartner(ourPartnerDTO);
        return dto;
    }
}