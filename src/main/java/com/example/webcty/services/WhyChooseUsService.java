package com.example.webcty.services;

import com.example.webcty.dto.request.WhyChooseUsRequest;
import com.example.webcty.dto.response.WhyChooseUsResponse;

import java.util.List;

public interface WhyChooseUsService {
    List<WhyChooseUsResponse> getAllWhyChooseUs();

    WhyChooseUsResponse getWhyChooseUsById(Long id);

    WhyChooseUsResponse createWhyChooseUs(WhyChooseUsRequest whyChooseUs);

    WhyChooseUsResponse updateWhyChooseUs(Long id, WhyChooseUsRequest updatedWhyChooseUs);

    void deleteWhyChooseUs(Long id);
}
