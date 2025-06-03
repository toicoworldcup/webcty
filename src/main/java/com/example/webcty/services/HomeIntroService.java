package com.example.webcty.services;

import com.example.webcty.dto.request.HomeIntroRequest;
import com.example.webcty.dto.response.HomeIntroResponse;

import java.util.List;

public interface HomeIntroService {
    List<HomeIntroResponse> getAllHomeIntro();

    HomeIntroResponse getHomeIntroById(Long id);

    HomeIntroResponse createHomeIntro(HomeIntroRequest homeIntro);

    HomeIntroResponse updateHomeIntro(Long id, HomeIntroRequest updatedHomeIntro);

    void deleteHomeIntro(Long id);
}
