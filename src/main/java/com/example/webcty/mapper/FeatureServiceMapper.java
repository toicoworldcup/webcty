package com.example.webcty.mapper;

import com.example.webcty.dto.request.FeatureServiceRequest;
import com.example.webcty.dto.response.FeatureServiceResponse;
import com.example.webcty.entities.FeatureService;
import org.springframework.stereotype.Component;

@Component
public class FeatureServiceMapper {
    public FeatureService toEntity(FeatureServiceRequest dto) {
        FeatureService featureService = new FeatureService();
        featureService.setTitle(dto.getTitle());
        featureService.setDescription(dto.getDescription());
        featureService.setImage(dto.getImage());
        featureService.setCreatedBy("admin"); // Mặc định created_by là admin
        return featureService;
    }

    public FeatureServiceResponse toResponseDTO(FeatureService entity) {
        FeatureServiceResponse dto = new FeatureServiceResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}