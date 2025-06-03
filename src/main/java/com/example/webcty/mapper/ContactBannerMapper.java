package com.example.webcty.mapper;

import com.example.webcty.dto.request.ContactBannerRequest;
import com.example.webcty.dto.response.ContactBannerResponse;
import com.example.webcty.entities.contactPage.ContactBanner;
import org.springframework.stereotype.Component;

@Component
public class ContactBannerMapper {
    public ContactBanner toEntity(ContactBannerRequest dto) {
        ContactBanner contactBanner = new ContactBanner();
        contactBanner.setSlogan(dto.getSlogan());
        contactBanner.setImage(dto.getImage());
        return contactBanner;
    }

    public ContactBannerResponse toResponseDTO(ContactBanner entity) {
        ContactBannerResponse dto = new ContactBannerResponse();
        dto.setId(entity.getId());
        dto.setSlogan(entity.getSlogan());
        dto.setImage(entity.getImage());
        return dto;
    }
}