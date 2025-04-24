package com.example.webcty.services;

import com.example.webcty.dto.request.BannerRequest;
import com.example.webcty.dto.response.BannerResponse;

import java.util.List;

public interface BannerService {
    List<BannerResponse> getAllBanners();

    BannerResponse getBannerById(Long id);

    BannerResponse createBanner(BannerRequest banner);

    BannerResponse updateBanner(Long id, BannerRequest updatedBanner);

    void deleteBanner(Long id);
}
