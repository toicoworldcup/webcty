package com.example.webcty.services.impl;

import com.example.webcty.dto.request.TechnologyRequest;
import com.example.webcty.dto.response.TechnologyResponse;
import com.example.webcty.entities.Technology;
import com.example.webcty.mapper.TechnologyMapper;
import com.example.webcty.repositories.TechnologyRepository;
import com.example.webcty.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
        this.technologyMapper = new TechnologyMapper();
    }

    @Override
    public List<TechnologyResponse> getAllTechnologys() {
        return technologyRepository.findAll().stream()
                .map(technologyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TechnologyResponse getTechnologyById(Long id) {
        Technology technology = technologyRepository.findById(id).orElse(null);
        return technology != null ? technologyMapper.toResponseDTO(technology) : null;
    }

    @Override
    public TechnologyResponse createTechnology(TechnologyRequest technologyDTO) {
        Technology technology = technologyMapper.toEntity(technologyDTO);
        Technology savedTechnology = technologyRepository.save(technology);
        return technologyMapper.toResponseDTO(savedTechnology);
    }

    @Override
    public TechnologyResponse updateTechnology(Long id, TechnologyRequest updatedtechnologyDTO) {
        Technology technology = technologyRepository.findById(id).orElse(null);
        if (technology != null) {
            technology.setTitle(updatedtechnologyDTO.getTitle());
            technology.setDescription(updatedtechnologyDTO.getDescription());
            technology.setImage(updatedtechnologyDTO.getImage());
            Technology updatedTechnology = technologyRepository.save(technology);
            return technologyMapper.toResponseDTO(updatedTechnology);
        }
        return null;
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }
}
