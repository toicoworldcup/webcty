package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhyChooseUsComponentRequest;
import com.example.webcty.dto.response.WhyChooseUsComponentResponse;
import com.example.webcty.dto.response.WhyChooseUsResponse;
import com.example.webcty.entities.homePage.WhyChooseUs;
import com.example.webcty.entities.homePage.WhyChooseUsComponent;
import com.example.webcty.repositories.WhyChooseUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhyChooseUsComponentMapper {
    private final WhyChooseUsRepository whyChooseUsRepository;
    private final WhyChooseUsMapper whyChooseUsMapper;

    @Autowired
    public WhyChooseUsComponentMapper(WhyChooseUsRepository whyChooseUsRepository, WhyChooseUsMapper whyChooseUsMapper) {
        this.whyChooseUsRepository = whyChooseUsRepository;
        this.whyChooseUsMapper = whyChooseUsMapper;
    }

    public WhyChooseUsComponent toEntity(WhyChooseUsComponentRequest dto) {
        WhyChooseUsComponent whyChooseUsComponent = new WhyChooseUsComponent();
        whyChooseUsComponent.setTitle(dto.getTitle());
        whyChooseUsComponent.setDescription(dto.getDescription());
        whyChooseUsComponent.setIcon(dto.getIcon());

        WhyChooseUs whyChooseUs = whyChooseUsRepository.findById(dto.getWhyChooseUsId())
                .orElseThrow(() -> new RuntimeException("WhyChooseUs not found"));
        whyChooseUsComponent.setWhyChooseUs(whyChooseUs);

        whyChooseUsComponent.setCreatedBy("admin"); // Mặc định created_by là admin
        return whyChooseUsComponent;
    }

    public WhyChooseUsComponentResponse toResponseDTO(WhyChooseUsComponent entity) {
        WhyChooseUsComponentResponse dto = new WhyChooseUsComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());

        WhyChooseUs whyChooseUs = entity.getWhyChooseUs();
        WhyChooseUsResponse whyChooseUsDTO = whyChooseUsMapper.toResponseDTO(whyChooseUs);
        dto.setWhyChooseUs(whyChooseUsDTO);
        return dto;
    }
}