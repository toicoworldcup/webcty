package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhoWeAreRequest;
import com.example.webcty.dto.response.WhoWeAreResponse;
import com.example.webcty.entities.aboutUsPage.WhoWeAre;
import com.example.webcty.mapper.WhoWeAreMapper;
import com.example.webcty.repositories.WhoWeAreRepository;
import com.example.webcty.services.WhoWeAreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhoWeAreServiceImpl implements WhoWeAreService {
    private final WhoWeAreRepository whoWeAreRepository;
    private final WhoWeAreMapper whoWeAreMapper;

    @Autowired
    public WhoWeAreServiceImpl(WhoWeAreRepository whoWeAreRepository, WhoWeAreMapper whoWeAreMapper) {
        this.whoWeAreRepository = whoWeAreRepository;
        this.whoWeAreMapper = whoWeAreMapper;
    }

    @Override
    public List<WhoWeAreResponse> getAllWhoWeAre() {
        return whoWeAreRepository.findAll().stream()
                .map(whoWeAreMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhoWeAreResponse getWhoWeAreById(Long id) {
        WhoWeAre whoWeAre = whoWeAreRepository.findById(id).orElse(null);
        return whoWeAre != null ? whoWeAreMapper.toResponseDTO(whoWeAre) : null;
    }

    @Override
    @Transactional
    public WhoWeAreResponse createWhoWeAre(WhoWeAreRequest whoWeAreDTO) {
        whoWeAreRepository.deleteAll();
        WhoWeAre whoWeAre = whoWeAreMapper.toEntity(whoWeAreDTO);
        WhoWeAre savedWhoWeAre = whoWeAreRepository.save(whoWeAre);
        return whoWeAreMapper.toResponseDTO(savedWhoWeAre);
    }

    @Override
    public WhoWeAreResponse updateWhoWeAre(Long id, WhoWeAreRequest updatedWhoWeAreDTO) {
        WhoWeAre whoWeAre = whoWeAreRepository.findById(id).orElse(null);
        if (whoWeAre != null) {
            whoWeAre.setTitle(updatedWhoWeAreDTO.getTitle());
            whoWeAre.setDescription(updatedWhoWeAreDTO.getDescription());
            WhoWeAre updatedWhoWeAre = whoWeAreRepository.save(whoWeAre);
            return whoWeAreMapper.toResponseDTO(updatedWhoWeAre);
        }
        return null;
    }

    @Override
    public void deleteWhoWeAre(Long id) {
        whoWeAreRepository.deleteById(id);
    }
}
