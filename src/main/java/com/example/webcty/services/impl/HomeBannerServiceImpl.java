package com.example.webcty.services.impl;

import com.example.webcty.dto.request.HomeBannerRequest;
import com.example.webcty.dto.response.HomeBannerResponse;
import com.example.webcty.entities.homePage.HomeBanner;
import com.example.webcty.mapper.HomeBannerMapper;
import com.example.webcty.repositories.HomeBannerRepository;
import com.example.webcty.services.HomeBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeBannerServiceImpl implements HomeBannerService {
    private final HomeBannerRepository homeBannerRepository;
    private final HomeBannerMapper homeBannerMapper;

    @Autowired
    public HomeBannerServiceImpl(HomeBannerRepository homeBannerRepository) {
        this.homeBannerRepository = homeBannerRepository;
        this.homeBannerMapper = new HomeBannerMapper();
    }

    @Override
    public List<HomeBannerResponse> getAllHomeBanner() {
        return homeBannerRepository.findAll().stream()
                .map(homeBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HomeBannerResponse getHomeBannerById(Long id) {
        HomeBanner homeBanner = homeBannerRepository.findById(id).orElse(null);
        return homeBanner != null ? homeBannerMapper.toResponseDTO(homeBanner) : null;
    }

    @Override
    @Transactional
    public HomeBannerResponse createHomeBanner(HomeBannerRequest bannerDTO) {
        homeBannerRepository.deleteAll();
        HomeBanner homeBanner = homeBannerMapper.toEntity(bannerDTO);
        HomeBanner savedHomeBanner = homeBannerRepository.save(homeBanner);
        return homeBannerMapper.toResponseDTO(savedHomeBanner);
    }

    @Override
    public HomeBannerResponse updateHomeBanner(Long id, HomeBannerRequest updatedBannerDTO) {
        HomeBanner homeBanner = homeBannerRepository.findById(id).orElse(null);
        if (homeBanner != null) {
            homeBanner.setSlogan(updatedBannerDTO.getSlogan());
            homeBanner.setImageUrls(updatedBannerDTO.getImageUrls());
            HomeBanner updatedHomeBanner = homeBannerRepository.save(homeBanner);
            return homeBannerMapper.toResponseDTO(updatedHomeBanner);
        }
        return null;
    }

    @Override
    public void deleteHomeBanner(Long id) {
        homeBannerRepository.deleteById(id);
    }
}
