package com.example.webcty.services;

import com.example.webcty.dto.request.HomeBannerRequest;
import com.example.webcty.dto.response.HomeBannerResponse;

import java.util.List;

public interface HomeBannerService {
    List<HomeBannerResponse> getAllHomeBanner();

    HomeBannerResponse getHomeBannerById(Long id);

    HomeBannerResponse createHomeBanner(HomeBannerRequest banner);

    HomeBannerResponse updateHomeBanner(Long id, HomeBannerRequest updatedBanner);

    void deleteHomeBanner(Long id);
}
