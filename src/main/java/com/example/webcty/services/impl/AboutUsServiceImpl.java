package com.example.webcty.services.impl;

import com.example.webcty.dto.request.AboutUsRequest;
import com.example.webcty.dto.response.AboutUsResponse;
import com.example.webcty.entities.AboutUs;
import com.example.webcty.mapper.AboutUsMapper;
import com.example.webcty.repositories.AboutUsRepository;
import com.example.webcty.services.AboutUsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsServiceImpl implements AboutUsService {
    private final AboutUsRepository aboutUsRepository;
    private final AboutUsMapper aboutUsMapper;

    @Autowired
    public AboutUsServiceImpl(AboutUsRepository aboutUsRepository, AboutUsMapper aboutUsMapper) {
        this.aboutUsRepository = aboutUsRepository;
        this.aboutUsMapper = aboutUsMapper;
    }

    @Override
    public List<AboutUsResponse> getAllAboutUs() {
        return aboutUsRepository.findAll().stream()
                .map(aboutUsMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AboutUsResponse getAboutUsById(Long id) {
        AboutUs aboutUs = aboutUsRepository.findById(id).orElse(null);
        return aboutUs != null ? aboutUsMapper.toResponseDTO(aboutUs) : null;
    }

    @Override
    @Transactional
    public AboutUsResponse createAboutUs(AboutUsRequest aboutUsDTO) {
        aboutUsRepository.deleteAll();
        AboutUs aboutUs = aboutUsMapper.toEntity(aboutUsDTO);
        AboutUs savedAboutUs = aboutUsRepository.save(aboutUs);
        return aboutUsMapper.toResponseDTO(savedAboutUs);
    }

    @Override
    public AboutUsResponse updateAboutUs(Long id, AboutUsRequest updatedAboutUsDTO) {
        AboutUs aboutUs = aboutUsRepository.findById(id).orElse(null);
        if (aboutUs != null) {
            aboutUs.setTitle(updatedAboutUsDTO.getTitle());
            aboutUs.setDescription(updatedAboutUsDTO.getDescription());
            aboutUs.setImage(updatedAboutUsDTO.getImage());
            AboutUs updatedAboutUs = aboutUsRepository.save(aboutUs);
            return aboutUsMapper.toResponseDTO(updatedAboutUs);
        }
        return null;
    }

    @Override
    public void deleteAboutUs(Long id) {
        aboutUsRepository.deleteById(id);
    }
}
