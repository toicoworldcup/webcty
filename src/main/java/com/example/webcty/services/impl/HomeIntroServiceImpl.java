package com.example.webcty.services.impl;

import com.example.webcty.dto.request.HomeIntroRequest;
import com.example.webcty.dto.response.HomeIntroResponse;
import com.example.webcty.entities.homePage.HomeIntro;
import com.example.webcty.mapper.HomeIntroMapper;
import com.example.webcty.repositories.HomeIntroRepository;
import com.example.webcty.services.HomeIntroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeIntroServiceImpl implements HomeIntroService {
    private final HomeIntroRepository homeIntroRepository;
    private final HomeIntroMapper homeIntroMapper;

    @Autowired
    public HomeIntroServiceImpl(HomeIntroRepository homeIntroRepository, HomeIntroMapper homeIntroMapper) {
        this.homeIntroRepository = homeIntroRepository;
        this.homeIntroMapper = homeIntroMapper;
    }

    @Override
    public List<HomeIntroResponse> getAllHomeIntro() {
        return homeIntroRepository.findAll().stream()
                .map(homeIntroMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HomeIntroResponse getHomeIntroById(Long id) {
        HomeIntro homeIntro = homeIntroRepository.findById(id).orElse(null);
        return homeIntro != null ? homeIntroMapper.toResponseDTO(homeIntro) : null;
    }

    @Override
    @Transactional
    public HomeIntroResponse createHomeIntro(HomeIntroRequest homeIntroDTO) {
        homeIntroRepository.deleteAll();
        HomeIntro homeIntro = homeIntroMapper.toEntity(homeIntroDTO);
        HomeIntro savedHomeIntro = homeIntroRepository.save(homeIntro);
        return homeIntroMapper.toResponseDTO(savedHomeIntro);
    }

    @Override
    public HomeIntroResponse updateHomeIntro(Long id, HomeIntroRequest updatedHomeIntroDTO) {
        HomeIntro homeIntro = homeIntroRepository.findById(id).orElse(null);
        if (homeIntro != null) {
            homeIntro.setTitle(updatedHomeIntroDTO.getTitle());
            homeIntro.setDescription(updatedHomeIntroDTO.getDescription());
            homeIntro.setContent(updatedHomeIntroDTO.getContent());
            homeIntro.setImage(updatedHomeIntroDTO.getImage());
            HomeIntro updatedHomeIntro = homeIntroRepository.save(homeIntro);
            return homeIntroMapper.toResponseDTO(updatedHomeIntro);
        }
        return null;
    }

    @Override
    public void deleteHomeIntro(Long id) {
        homeIntroRepository.deleteById(id);
    }
}
