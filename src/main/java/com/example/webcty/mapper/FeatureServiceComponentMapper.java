package com.example.webcty.mapper;

import com.example.webcty.dto.request.FeatureServiceComponentRequest;
import com.example.webcty.dto.response.FeatureServiceComponentResponse;
import com.example.webcty.dto.response.FeatureServiceResponse;
import com.example.webcty.entities.servicePage.FeatureService;
import com.example.webcty.entities.servicePage.FeatureServiceComponent;
import com.example.webcty.repositories.FeatureServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeatureServiceComponentMapper {
    private final FeatureServiceRepository featureServiceRepository;
    private final FeatureServiceMapper featureServiceMapper;

    @Autowired
    public FeatureServiceComponentMapper(FeatureServiceRepository featureServiceRepository, FeatureServiceMapper featureServiceMapper) {
        this.featureServiceRepository = featureServiceRepository;
        this.featureServiceMapper = featureServiceMapper;
    }

    public FeatureServiceComponent toEntity(FeatureServiceComponentRequest dto) {
        FeatureServiceComponent featureServiceComponent = new FeatureServiceComponent();
        featureServiceComponent.setTitle(dto.getTitle());
        featureServiceComponent.setDescription(dto.getDescription());
        featureServiceComponent.setImage(dto.getImage());

        FeatureService featureService = featureServiceRepository.findById(dto.getFeatureServiceId())
                .orElseThrow(() -> new RuntimeException("FeatureService not found"));
        featureServiceComponent.setFeatureService(featureService);

        featureServiceComponent.setCreatedBy("admin"); // Mặc định created_by là admin
        return featureServiceComponent;
    }

    public FeatureServiceComponentResponse toResponseDTO(FeatureServiceComponent entity) {
        FeatureServiceComponentResponse dto = new FeatureServiceComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());

        FeatureService featureService = entity.getFeatureService();
        FeatureServiceResponse featureServiceDTO = featureServiceMapper.toResponseDTO(featureService);
        dto.setFeatureService(featureServiceDTO);
        return dto;
    }
}