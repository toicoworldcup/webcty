package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhoWeAreComponentRequest;
import com.example.webcty.dto.response.WhoWeAreComponentResponse;
import com.example.webcty.entities.aboutUsPage.WhoWeAreComponent;
import com.example.webcty.mapper.WhoWeAreComponentMapper;
import com.example.webcty.repositories.WhoWeAreComponentRepository;
import com.example.webcty.services.WhoWeAreComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhoWeAreComponentServiceImpl implements WhoWeAreComponentService {
    private final WhoWeAreComponentRepository whoWeAreComponentRepository;
    private final WhoWeAreComponentMapper whoWeAreComponentMapper;

    @Autowired
    public WhoWeAreComponentServiceImpl(WhoWeAreComponentRepository whoWeAreComponentRepository, WhoWeAreComponentMapper whoWeAreComponentMapper) {
        this.whoWeAreComponentRepository = whoWeAreComponentRepository;
        this.whoWeAreComponentMapper = whoWeAreComponentMapper;
    }

    @Override
    public List<WhoWeAreComponentResponse> getAllWhoWeAreComponent() {
        return whoWeAreComponentRepository.findAll().stream()
                .map(whoWeAreComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhoWeAreComponentResponse getWhoWeAreComponentById(Long id) {
        WhoWeAreComponent whoWeAreComponent = whoWeAreComponentRepository.findById(id).orElse(null);
        return whoWeAreComponent != null ? whoWeAreComponentMapper.toResponseDTO(whoWeAreComponent) : null;
    }

    @Override
    public WhoWeAreComponentResponse createWhoWeAreComponent(WhoWeAreComponentRequest whoWeAreComponentDTO) {
        WhoWeAreComponent whoWeAreComponent = whoWeAreComponentMapper.toEntity(whoWeAreComponentDTO);
        WhoWeAreComponent savedWhoWeAreComponent = whoWeAreComponentRepository.save(whoWeAreComponent);
        return whoWeAreComponentMapper.toResponseDTO(savedWhoWeAreComponent);
    }

    @Override
    public WhoWeAreComponentResponse updateWhoWeAreComponent(Long id, WhoWeAreComponentRequest updatedWhoWeAreComponentDTO) {
        WhoWeAreComponent whoWeAreComponent = whoWeAreComponentRepository.findById(id).orElse(null);
        if (whoWeAreComponent != null) {
            whoWeAreComponent.setContent(updatedWhoWeAreComponentDTO.getContent());
            WhoWeAreComponent updatedWhoWeAreComponent = whoWeAreComponentRepository.save(whoWeAreComponent);
            return whoWeAreComponentMapper.toResponseDTO(updatedWhoWeAreComponent);
        }
        return null;
    }

    @Override
    public void deleteWhoWeAreComponent(Long id) {
        whoWeAreComponentRepository.deleteById(id);
    }
}
