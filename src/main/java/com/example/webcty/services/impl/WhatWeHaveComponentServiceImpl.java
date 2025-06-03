package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhatWeHaveComponentRequest;
import com.example.webcty.dto.response.WhatWeHaveComponentResponse;
import com.example.webcty.entities.homePage.WhatWeHaveComponent;
import com.example.webcty.mapper.WhatWeHaveComponentMapper;
import com.example.webcty.repositories.WhatWeHaveComponentRepository;
import com.example.webcty.services.WhatWeHaveComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhatWeHaveComponentServiceImpl implements WhatWeHaveComponentService {
    private final WhatWeHaveComponentRepository whatWeHaveComponentRepository;
    private final WhatWeHaveComponentMapper whatWeHaveComponentMapper;

    @Autowired
    public WhatWeHaveComponentServiceImpl(WhatWeHaveComponentRepository whatWeHaveComponentRepository, WhatWeHaveComponentMapper whatWeHaveComponentMapper) {
        this.whatWeHaveComponentRepository = whatWeHaveComponentRepository;
        this.whatWeHaveComponentMapper = whatWeHaveComponentMapper;
    }

    @Override
    public List<WhatWeHaveComponentResponse> getAllWhatWeHave() {
        return whatWeHaveComponentRepository.findAll().stream()
                .map(whatWeHaveComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhatWeHaveComponentResponse getWhatWeHaveById(Long id) {
        WhatWeHaveComponent whatWeHaveComponent = whatWeHaveComponentRepository.findById(id).orElse(null);
        return whatWeHaveComponent != null ? whatWeHaveComponentMapper.toResponseDTO(whatWeHaveComponent) : null;
    }

    @Override
    public WhatWeHaveComponentResponse createWhatWeHave(WhatWeHaveComponentRequest whatWeHaveComponentDTO) {
        WhatWeHaveComponent whatWeHaveComponent = whatWeHaveComponentMapper.toEntity(whatWeHaveComponentDTO);
        WhatWeHaveComponent savedWhatWeHaveComponent = whatWeHaveComponentRepository.save(whatWeHaveComponent);
        return whatWeHaveComponentMapper.toResponseDTO(savedWhatWeHaveComponent);
    }

    @Override
    public WhatWeHaveComponentResponse updateWhatWeHave(Long id, WhatWeHaveComponentRequest updatedWhatWeHaveComponentDTO) {
        WhatWeHaveComponent whatWeHaveComponent = whatWeHaveComponentRepository.findById(id).orElse(null);
        if (whatWeHaveComponent != null) {
            whatWeHaveComponent.setTitle(updatedWhatWeHaveComponentDTO.getTitle());
            whatWeHaveComponent.setDescription(updatedWhatWeHaveComponentDTO.getDescription());
            whatWeHaveComponent.setImage(updatedWhatWeHaveComponentDTO.getImage());;
            whatWeHaveComponent.setTags(updatedWhatWeHaveComponentDTO.getTags());
            WhatWeHaveComponent updatedWhatWeHaveComponent = whatWeHaveComponentRepository.save(whatWeHaveComponent);
            return whatWeHaveComponentMapper.toResponseDTO(updatedWhatWeHaveComponent);
        }
        return null;
    }

    @Override
    public void deleteWhatWeHave(Long id) {
        whatWeHaveComponentRepository.deleteById(id);
    }
}
