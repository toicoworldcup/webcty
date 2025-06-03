package com.example.webcty.services;

import com.example.webcty.dto.request.OurPartnerRequest;
import com.example.webcty.dto.response.OurPartnerResponse;

import java.util.List;

public interface OurPartnerService {
    List<OurPartnerResponse> getAllOurPartner();

    OurPartnerResponse getOurPartnerById(Long id);

    OurPartnerResponse createOurPartner(OurPartnerRequest ourPartner);

    OurPartnerResponse updateOurPartner(Long id, OurPartnerRequest updatedOurPartner);

    void deleteOurPartner(Long id);
}
