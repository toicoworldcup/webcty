package com.example.webcty.services.impl;

import com.example.webcty.dto.request.FeatureServiceRequest;
import com.example.webcty.dto.response.FeatureServiceResponse;
import com.example.webcty.entities.servicePage.FeatureService;
import com.example.webcty.mapper.FeatureServiceMapper;
import com.example.webcty.repositories.FeatureServiceRepository;
import com.example.webcty.services.FeatureServiceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceServiceImpl implements FeatureServiceService {
    private final FeatureServiceRepository featureServiceRepository;
    private final FeatureServiceMapper featureServiceMapper;

    @Autowired
    public FeatureServiceServiceImpl(FeatureServiceRepository featureServiceRepository, FeatureServiceMapper featureServiceMapper) {
        this.featureServiceRepository = featureServiceRepository;
        this.featureServiceMapper = featureServiceMapper;
    }

    @Override
    public List<FeatureServiceResponse> getAllFeatureService() {
        return featureServiceRepository.findAll().stream()
                .map(featureServiceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FeatureServiceResponse getFeatureServiceById(Long id) {
        FeatureService featureService = featureServiceRepository.findById(id).orElse(null);
        return featureService != null ? featureServiceMapper.toResponseDTO(featureService) : null;
    }

    @Override
    @Transactional
    public FeatureServiceResponse createFeatureService(FeatureServiceRequest featureServiceDTO) {
        featureServiceRepository.deleteAll();
        FeatureService featureService = featureServiceMapper.toEntity(featureServiceDTO);
        FeatureService savedFeatureService = featureServiceRepository.save(featureService);
        return featureServiceMapper.toResponseDTO(savedFeatureService);
    }

    @Override
    public FeatureServiceResponse updateFeatureService(Long id, FeatureServiceRequest updatedFeatureServiceDTO) {
        FeatureService featureService = featureServiceRepository.findById(id).orElse(null);
        if (featureService != null) {
            featureService.setTitle(updatedFeatureServiceDTO.getTitle());
            featureService.setDescription(updatedFeatureServiceDTO.getDescription());
            FeatureService updatedfeatureService = featureServiceRepository.save(featureService);
            return featureServiceMapper.toResponseDTO(updatedfeatureService);
        }
        return null;
    }

    @Override
    public void deleteFeatureService(Long id) {
        featureServiceRepository.deleteById(id);
    }
}
