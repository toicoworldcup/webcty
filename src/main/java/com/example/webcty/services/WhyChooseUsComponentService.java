package com.example.webcty.services;

import com.example.webcty.dto.request.WhyChooseUsComponentRequest;
import com.example.webcty.dto.response.WhyChooseUsComponentResponse;

import java.util.List;

public interface WhyChooseUsComponentService {
    List<WhyChooseUsComponentResponse> getAllWhyChooseUsComponent();

    WhyChooseUsComponentResponse getWhyChooseUsComponentById(Long id);

    WhyChooseUsComponentResponse createWhyChooseUsComponent(WhyChooseUsComponentRequest whyChooseUsComponent);

    WhyChooseUsComponentResponse updateWhyChooseUsComponent(Long id, WhyChooseUsComponentRequest updatedWhyChooseUsComponent);

    void deleteWhyChooseUsComponent(Long id);
}
