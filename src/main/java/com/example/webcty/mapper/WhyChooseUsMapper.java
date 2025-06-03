package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhyChooseUsRequest;
import com.example.webcty.dto.response.WhyChooseUsResponse;
import com.example.webcty.entities.homePage.WhyChooseUs;
import org.springframework.stereotype.Component;

@Component
public class WhyChooseUsMapper {
    public WhyChooseUs toEntity(WhyChooseUsRequest dto) {
        WhyChooseUs whyChooseUs = new WhyChooseUs();
        whyChooseUs.setTitle(dto.getTitle());
        whyChooseUs.setDescription(dto.getDescription());
        return whyChooseUs;
    }

    public WhyChooseUsResponse toResponseDTO(WhyChooseUs entity) {
        WhyChooseUsResponse dto = new WhyChooseUsResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}