package com.example.webcty.services;

import com.example.webcty.dto.request.AboutUsBannerRequest;
import com.example.webcty.dto.response.AboutUsBannerResponse;

import java.util.List;

public interface AboutUsBannerService {
    List<AboutUsBannerResponse> getAllAboutUsBanner();

    AboutUsBannerResponse getAboutUsBannerById(Long id);

    AboutUsBannerResponse createAboutUsBanner(AboutUsBannerRequest aboutUsBanner);

    AboutUsBannerResponse updateAboutUsBanner(Long id, AboutUsBannerRequest updatedAboutUsBanner);

    void deleteAboutUsBanner(Long id);
}
