package com.example.webcty.services;

import com.example.webcty.dto.request.ContactBannerRequest;
import com.example.webcty.dto.response.ContactBannerResponse;

import java.util.List;

public interface ContactBannerService {
    List<ContactBannerResponse> getAllContactBanner();

    ContactBannerResponse getContactBannerById(Long id);

    ContactBannerResponse createContactBanner(ContactBannerRequest contactBanner);

    ContactBannerResponse updateContactBanner(Long id, ContactBannerRequest updatedContactBanner);

    void deleteContactBanner(Long id);
}
