package com.example.webcty.services;

import com.example.webcty.dto.request.AboutUsIntroRequest;
import com.example.webcty.dto.response.AboutUsIntroResponse;

import java.util.List;

public interface AboutUsIntroService {
    List<AboutUsIntroResponse> getAllAboutUsIntro();

    AboutUsIntroResponse getAboutUsIntroById(Long id);

    AboutUsIntroResponse createAboutUsIntro(AboutUsIntroRequest aboutUsIntro);

    AboutUsIntroResponse updateAboutUsIntro(Long id, AboutUsIntroRequest updatedAboutUsIntro);

    void deleteAboutUsIntro(Long id);
}
