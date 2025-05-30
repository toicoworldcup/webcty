package com.example.webcty.services.impl;

import com.example.webcty.dto.request.FeatureServiceComponentRequest;
import com.example.webcty.dto.response.FeatureServiceComponentResponse;
import com.example.webcty.entities.servicePage.FeatureServiceComponent;
import com.example.webcty.mapper.FeatureServiceComponentMapper;
import com.example.webcty.repositories.FeatureServiceComponentRepository;
import com.example.webcty.services.FeatureServiceComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceComponentServiceImpl implements FeatureServiceComponentService {
    private final FeatureServiceComponentRepository featureServiceComponentRepository;
    private final FeatureServiceComponentMapper featureServiceComponentMapper;

    @Autowired
    public FeatureServiceComponentServiceImpl(FeatureServiceComponentRepository featureServiceComponentRepository, FeatureServiceComponentMapper featureServiceComponentMapper) {
        this.featureServiceComponentRepository = featureServiceComponentRepository;
        this.featureServiceComponentMapper = featureServiceComponentMapper;
    }

    @Override
    public List<FeatureServiceComponentResponse> getAllFeatureServiceComponent() {
        return featureServiceComponentRepository.findAll().stream()
                .map(featureServiceComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeatureServiceComponentResponse getFeatureServiceComponentById(Long id) {
        FeatureServiceComponent featureServiceComponent = featureServiceComponentRepository.findById(id).orElse(null);
        return featureServiceComponent != null ? featureServiceComponentMapper.toResponseDTO(featureServiceComponent) : null;
    }

    @Override
    public FeatureServiceComponentResponse createFeatureServiceComponent(FeatureServiceComponentRequest featureServiceComponentDTO) {
        FeatureServiceComponent featureServiceComponent = featureServiceComponentMapper.toEntity(featureServiceComponentDTO);
        FeatureServiceComponent savedFeatureServiceComponent = featureServiceComponentRepository.save(featureServiceComponent);
        return featureServiceComponentMapper.toResponseDTO(savedFeatureServiceComponent);
    }

    @Override
    public FeatureServiceComponentResponse updateFeatureServiceComponent(Long id, FeatureServiceComponentRequest updatedFeatureServiceComponentDTO) {
        FeatureServiceComponent featureServiceComponent = featureServiceComponentRepository.findById(id).orElse(null);
        if (featureServiceComponent != null) {
            featureServiceComponent.setTitle(updatedFeatureServiceComponentDTO.getTitle());
            featureServiceComponent.setDescription(updatedFeatureServiceComponentDTO.getDescription());
            featureServiceComponent.setImage(updatedFeatureServiceComponentDTO.getImage());
            FeatureServiceComponent updatedFeatureServiceComponent = featureServiceComponentRepository.save(featureServiceComponent);
            return featureServiceComponentMapper.toResponseDTO(updatedFeatureServiceComponent);
        }
        return null;
    }

    @Override
    public void deleteFeatureServiceComponent(Long id) {
        featureServiceComponentRepository.deleteById(id);
    }
}
