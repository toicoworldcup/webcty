package com.example.webcty.services;

import com.example.webcty.dto.request.OurPartnerComponentRequest;
import com.example.webcty.dto.response.OurPartnerComponentResponse;

import java.util.List;

public interface OurPartnerComponentService {
    List<OurPartnerComponentResponse> getAllOurPartnerComponent();

    OurPartnerComponentResponse getOurPartnerComponentById(Long id);

    OurPartnerComponentResponse createOurPartnerComponent(OurPartnerComponentRequest ourPartnerComponent);

    OurPartnerComponentResponse updateOurPartnerComponent(Long id, OurPartnerComponentRequest updatedOurPartnerComponent);

    void deleteOurPartnerComponent(Long id);
}
