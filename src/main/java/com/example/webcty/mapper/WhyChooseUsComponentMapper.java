package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhyChooseUsComponentRequest;
import com.example.webcty.dto.response.WhyChooseUsComponentResponse;
import com.example.webcty.entities.homePage.WhyChooseUsComponent;
import org.springframework.stereotype.Component;

@Component
public class WhyChooseUsComponentMapper {
    public WhyChooseUsComponent toEntity(WhyChooseUsComponentRequest dto) {
        WhyChooseUsComponent whyChooseUsComponent = new WhyChooseUsComponent();
        whyChooseUsComponent.setTitle(dto.getTitle());
        whyChooseUsComponent.setDescription(dto.getDescription());
        whyChooseUsComponent.setIcon(dto.getIcon());
        return whyChooseUsComponent;
    }

    public WhyChooseUsComponentResponse toResponseDTO(WhyChooseUsComponent entity) {
        WhyChooseUsComponentResponse dto = new WhyChooseUsComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        return dto;
    }
}