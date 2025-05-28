package com.example.webcty.services.impl;

import com.example.webcty.dto.request.OurPartnerRequest;
import com.example.webcty.dto.response.OurPartnerResponse;
import com.example.webcty.entities.homePage.OurPartner;
import com.example.webcty.mapper.OurPartnerMapper;
import com.example.webcty.repositories.OurPartnerRepository;
import com.example.webcty.services.OurPartnerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OurPartnerServiceImpl implements OurPartnerService {
    private final OurPartnerRepository ourPartnerRepository;
    private final OurPartnerMapper ourPartnerMapper;

    @Autowired
    public OurPartnerServiceImpl(OurPartnerRepository ourPartnerRepository, OurPartnerMapper ourPartnerMapper) {
        this.ourPartnerRepository = ourPartnerRepository;
        this.ourPartnerMapper = ourPartnerMapper;
    }

    @Override
    public List<OurPartnerResponse> getAllOurPartner() {
        return ourPartnerRepository.findAll().stream()
                .map(ourPartnerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OurPartnerResponse getOurPartnerById(Long id) {
        OurPartner ourPartner = ourPartnerRepository.findById(id).orElse(null);
        return ourPartner != null ? ourPartnerMapper.toResponseDTO(ourPartner) : null;
    }

    @Override
    @Transactional
    public OurPartnerResponse createOurPartner(OurPartnerRequest ourPartnerDTO) {
        ourPartnerRepository.deleteAll();
        OurPartner ourPartner = ourPartnerMapper.toEntity(ourPartnerDTO);
        OurPartner savedOurPartner = ourPartnerRepository.save(ourPartner);
        return ourPartnerMapper.toResponseDTO(savedOurPartner);
    }

    @Override
    public OurPartnerResponse updateOurPartner(Long id, OurPartnerRequest updatedOurPartnerDTO) {
        OurPartner ourPartner = ourPartnerRepository.findById(id).orElse(null);
        if (ourPartner != null) {
            ourPartner.setTitle(updatedOurPartnerDTO.getTitle());
            ourPartner.setDescription(updatedOurPartnerDTO.getDescription());
            OurPartner updatedOurPartner = ourPartnerRepository.save(ourPartner);
            return ourPartnerMapper.toResponseDTO(updatedOurPartner);
        }
        return null;
    }

    @Override
    public void deleteOurPartner(Long id) {
        ourPartnerRepository.deleteById(id);
    }
}
