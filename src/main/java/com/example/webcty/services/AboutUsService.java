package com.example.webcty.services;

import com.example.webcty.dto.request.AboutUsRequest;
import com.example.webcty.dto.response.AboutUsResponse;

import java.util.List;

public interface AboutUsService {
    List<AboutUsResponse> getAllAboutUs();

    AboutUsResponse getAboutUsById(Long id);

    AboutUsResponse createAboutUs(AboutUsRequest aboutUs);

    AboutUsResponse updateAboutUs(Long id, AboutUsRequest updatedAboutUs);

    void deleteAboutUs(Long id);
}
