package com.example.webcty.services.impl;

import com.example.webcty.dto.request.AboutUsBannerRequest;
import com.example.webcty.dto.response.AboutUsBannerResponse;
import com.example.webcty.entities.aboutUsPage.AboutUsBanner;
import com.example.webcty.mapper.AboutUsBannerMapper;
import com.example.webcty.repositories.AboutUsBannerRepository;
import com.example.webcty.services.AboutUsBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutUsBannerServiceImpl implements AboutUsBannerService {
    private final AboutUsBannerRepository aboutUsBannerRepository;
    private final AboutUsBannerMapper aboutUsBannerMapper;

    @Autowired
    public AboutUsBannerServiceImpl(AboutUsBannerRepository aboutUsBannerRepository, AboutUsBannerMapper aboutUsBannerMapper) {
        this.aboutUsBannerRepository = aboutUsBannerRepository;
        this.aboutUsBannerMapper = aboutUsBannerMapper;
    }

    @Override
    public List<AboutUsBannerResponse> getAllAboutUsBanner() {
        return aboutUsBannerRepository.findAll().stream()
                .map(aboutUsBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AboutUsBannerResponse getAboutUsBannerById(Long id) {
        AboutUsBanner aboutUsBanner = aboutUsBannerRepository.findById(id).orElse(null);
        return aboutUsBanner != null ? aboutUsBannerMapper.toResponseDTO(aboutUsBanner) : null;
    }

    @Override
    @Transactional
    public AboutUsBannerResponse createAboutUsBanner(AboutUsBannerRequest aboutUsBannerDTO) {
        aboutUsBannerRepository.deleteAll();
        AboutUsBanner aboutUsBanner = aboutUsBannerMapper.toEntity(aboutUsBannerDTO);
        AboutUsBanner savedAboutUsBanner = aboutUsBannerRepository.save(aboutUsBanner);
        return aboutUsBannerMapper.toResponseDTO(savedAboutUsBanner);
    }

    @Override
    public AboutUsBannerResponse updateAboutUsBanner(Long id, AboutUsBannerRequest updatedAboutUsBannerDTO) {
        AboutUsBanner aboutUsBanner = aboutUsBannerRepository.findById(id).orElse(null);
        if (aboutUsBanner != null) {
            aboutUsBanner.setSlogan(updatedAboutUsBannerDTO.getSlogan());
            aboutUsBanner.setImage(updatedAboutUsBannerDTO.getImage());
            AboutUsBanner updatedAboutUsBanner = aboutUsBannerRepository.save(aboutUsBanner);
            return aboutUsBannerMapper.toResponseDTO(updatedAboutUsBanner);
        }
        return null;
    }

    @Override
    public void deleteAboutUsBanner(Long id) {
        aboutUsBannerRepository.deleteById(id);
    }
}
