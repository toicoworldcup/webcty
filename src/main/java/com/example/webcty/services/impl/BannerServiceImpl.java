package com.example.webcty.services.impl;

import com.example.webcty.dto.request.BannerRequest;
import com.example.webcty.dto.response.BannerResponse;
import com.example.webcty.entities.Banner;
import com.example.webcty.mapper.BannerMapper;
import com.example.webcty.repositories.BannerRepository;
import com.example.webcty.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Autowired
    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
        this.bannerMapper = new BannerMapper();
    }

    @Override
    public List<BannerResponse> getAllBanners() {
        return bannerRepository.findAll().stream()
                .map(bannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BannerResponse getBannerById(Long id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        return banner != null ? bannerMapper.toResponseDTO(banner) : null;
    }

    @Override
    public BannerResponse createBanner(BannerRequest bannerDTO) {
        Banner banner = bannerMapper.toEntity(bannerDTO);
        Banner savedBanner = bannerRepository.save(banner);
        return bannerMapper.toResponseDTO(savedBanner);
    }

    @Override
    public BannerResponse updateBanner(Long id, BannerRequest updatedBannerDTO) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        if (banner != null) {
            banner.setTitle(updatedBannerDTO.getTitle());
            banner.setDescription(updatedBannerDTO.getDescription());
            banner.setImageUrls(updatedBannerDTO.getImageUrls());
            Banner updatedBanner = bannerRepository.save(banner);
            return bannerMapper.toResponseDTO(updatedBanner);
        }
        return null;
    }

    @Override
    public void deleteBanner(Long id) {
        bannerRepository.deleteById(id);
    }
}
