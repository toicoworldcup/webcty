package com.example.webcty.services;

import com.example.webcty.dto.request.WhoWeAreRequest;
import com.example.webcty.dto.response.WhoWeAreResponse;

import java.util.List;

public interface WhoWeAreService {
    List<WhoWeAreResponse> getAllWhoWeAre();

    WhoWeAreResponse getWhoWeAreById(Long id);

    WhoWeAreResponse createWhoWeAre(WhoWeAreRequest whoWeAre);

    WhoWeAreResponse updateWhoWeAre(Long id, WhoWeAreRequest updatedWhoWeAre);

    void deleteWhoWeAre(Long id);
}
