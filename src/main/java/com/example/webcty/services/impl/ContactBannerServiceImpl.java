package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ContactBannerRequest;
import com.example.webcty.dto.response.ContactBannerResponse;
import com.example.webcty.entities.contactPage.ContactBanner;
import com.example.webcty.mapper.ContactBannerMapper;
import com.example.webcty.repositories.ContactBannerRepository;
import com.example.webcty.services.ContactBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactBannerServiceImpl implements ContactBannerService {
    private final ContactBannerRepository contactBannerRepository;
    private final ContactBannerMapper contactBannerMapper;

    @Autowired
    public ContactBannerServiceImpl(ContactBannerRepository contactBannerRepository, ContactBannerMapper contactBannerMapper) {
        this.contactBannerRepository = contactBannerRepository;
        this.contactBannerMapper = contactBannerMapper;
    }

    @Override
    public List<ContactBannerResponse> getAllContactBanner() {
        return contactBannerRepository.findAll().stream()
                .map(contactBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactBannerResponse getContactBannerById(Long id) {
        ContactBanner contactBanner = contactBannerRepository.findById(id).orElse(null);
        return contactBanner != null ? contactBannerMapper.toResponseDTO(contactBanner) : null;
    }

    @Override
    @Transactional
    public ContactBannerResponse createContactBanner(ContactBannerRequest contactBannerDTO) {
        contactBannerRepository.deleteAll();
        ContactBanner contactBanner = contactBannerMapper.toEntity(contactBannerDTO);
        ContactBanner savedContactBanner = contactBannerRepository.save(contactBanner);
        return contactBannerMapper.toResponseDTO(savedContactBanner);
    }

    @Override
    public ContactBannerResponse updateContactBanner(Long id, ContactBannerRequest updatedContactBannerDTO) {
        ContactBanner contactBanner = contactBannerRepository.findById(id).orElse(null);
        if (contactBanner != null) {
            contactBanner.setSlogan(updatedContactBannerDTO.getSlogan());
            contactBanner.setImage(updatedContactBannerDTO.getImage());
            ContactBanner updatedContactBanner = contactBannerRepository.save(contactBanner);
            return contactBannerMapper.toResponseDTO(updatedContactBanner);
        }
        return null;
    }

    @Override
    public void deleteContactBanner(Long id) {
        contactBannerRepository.deleteById(id);
    }
}
