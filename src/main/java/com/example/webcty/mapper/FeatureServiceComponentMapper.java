package com.example.webcty.mapper;

import com.example.webcty.dto.request.FeatureServiceComponentRequest;
import com.example.webcty.dto.response.FeatureServiceComponentResponse;
import com.example.webcty.entities.servicePage.FeatureServiceComponent;
import org.springframework.stereotype.Component;

@Component
public class FeatureServiceComponentMapper {
        public FeatureServiceComponent toEntity(FeatureServiceComponentRequest dto) {
        FeatureServiceComponent featureServiceComponent = new FeatureServiceComponent();
        featureServiceComponent.setTitle(dto.getTitle());
        featureServiceComponent.setDescription(dto.getDescription());
        featureServiceComponent.setImage(dto.getImage());
        return featureServiceComponent;
    }

    public FeatureServiceComponentResponse toResponseDTO(FeatureServiceComponent entity) {
        FeatureServiceComponentResponse dto = new FeatureServiceComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}