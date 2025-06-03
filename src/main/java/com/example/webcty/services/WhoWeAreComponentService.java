package com.example.webcty.services;

import com.example.webcty.dto.request.WhoWeAreComponentRequest;
import com.example.webcty.dto.response.WhoWeAreComponentResponse;

import java.util.List;

public interface WhoWeAreComponentService {
    List<WhoWeAreComponentResponse> getAllWhoWeAreComponent();

    WhoWeAreComponentResponse getWhoWeAreComponentById(Long id);

    WhoWeAreComponentResponse createWhoWeAreComponent(WhoWeAreComponentRequest whoWeAreComponent);

    WhoWeAreComponentResponse updateWhoWeAreComponent(Long id, WhoWeAreComponentRequest updatedWhoWeAreComponent);

    void deleteWhoWeAreComponent(Long id);
}
