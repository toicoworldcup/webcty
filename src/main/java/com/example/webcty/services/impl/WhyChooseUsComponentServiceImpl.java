package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhyChooseUsComponentRequest;
import com.example.webcty.dto.response.WhyChooseUsComponentResponse;
import com.example.webcty.entities.homePage.WhyChooseUsComponent;
import com.example.webcty.mapper.WhyChooseUsComponentMapper;
import com.example.webcty.repositories.WhyChooseUsComponentRepository;
import com.example.webcty.services.WhyChooseUsComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhyChooseUsComponentServiceImpl implements WhyChooseUsComponentService {
    private final WhyChooseUsComponentRepository whyChooseUsComponentRepository;
    private final WhyChooseUsComponentMapper whyChooseUsComponentMapper;

    @Autowired
    public WhyChooseUsComponentServiceImpl(WhyChooseUsComponentRepository whyChooseUsComponentRepository, WhyChooseUsComponentMapper whyChooseUsComponentMapper) {
        this.whyChooseUsComponentRepository = whyChooseUsComponentRepository;
        this.whyChooseUsComponentMapper = whyChooseUsComponentMapper;
    }

    @Override
    public List<WhyChooseUsComponentResponse> getAllWhyChooseUsComponent() {
        return whyChooseUsComponentRepository.findAll().stream()
                .map(whyChooseUsComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhyChooseUsComponentResponse getWhyChooseUsComponentById(Long id) {
        WhyChooseUsComponent whyChooseUsComponent = whyChooseUsComponentRepository.findById(id).orElse(null);
        return whyChooseUsComponent != null ? whyChooseUsComponentMapper.toResponseDTO(whyChooseUsComponent) : null;
    }

    @Override
    public WhyChooseUsComponentResponse createWhyChooseUsComponent(WhyChooseUsComponentRequest whyChooseUsComponentDTO) {
        WhyChooseUsComponent whyChooseUsComponent = whyChooseUsComponentMapper.toEntity(whyChooseUsComponentDTO);
        WhyChooseUsComponent savedWhyChooseUsComponent = whyChooseUsComponentRepository.save(whyChooseUsComponent);
        return whyChooseUsComponentMapper.toResponseDTO(savedWhyChooseUsComponent);
    }

    @Override
    public WhyChooseUsComponentResponse updateWhyChooseUsComponent(Long id, WhyChooseUsComponentRequest updatedWhyChooseUsComponentDTO) {
        WhyChooseUsComponent whyChooseUsComponent = whyChooseUsComponentRepository.findById(id).orElse(null);
        if (whyChooseUsComponent != null) {
            whyChooseUsComponent.setTitle(updatedWhyChooseUsComponentDTO.getTitle());
            whyChooseUsComponent.setDescription(updatedWhyChooseUsComponentDTO.getDescription());
            whyChooseUsComponent.setIcon(updatedWhyChooseUsComponentDTO.getIcon());
            WhyChooseUsComponent updatedWhyChooseUsComponent = whyChooseUsComponentRepository.save(whyChooseUsComponent);
            return whyChooseUsComponentMapper.toResponseDTO(updatedWhyChooseUsComponent);
        }
        return null;
    }

    @Override
    public void deleteWhyChooseUsComponent(Long id) {
        whyChooseUsComponentRepository.deleteById(id);
    }
}
