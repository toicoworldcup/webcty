package com.example.webcty.services.impl;

import com.example.webcty.dto.request.OurPartnerComponentRequest;
import com.example.webcty.dto.response.OurPartnerComponentResponse;
import com.example.webcty.entities.homePage.OurPartner;
import com.example.webcty.entities.homePage.OurPartnerComponent;
import com.example.webcty.mapper.OurPartnerComponentMapper;
import com.example.webcty.repositories.OurPartnerComponentRepository;
import com.example.webcty.repositories.OurPartnerRepository;
import com.example.webcty.services.OurPartnerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OurPartnerComponentServiceImpl implements OurPartnerComponentService {
    private final OurPartnerComponentRepository ourPartnerComponentRepository;
    private final OurPartnerComponentMapper ourPartnerComponentMapper;
    private final OurPartnerRepository ourPartnerRepository;

    @Autowired
    public OurPartnerComponentServiceImpl(OurPartnerComponentRepository ourPartnerComponentRepository, OurPartnerComponentMapper ourPartnerComponentMapper, OurPartnerRepository ourPartnerRepository) {
        this.ourPartnerComponentRepository = ourPartnerComponentRepository;
        this.ourPartnerComponentMapper = ourPartnerComponentMapper;
        this.ourPartnerRepository = ourPartnerRepository;
    }

    @Override
    public List<OurPartnerComponentResponse> getAllOurPartnerComponent() {
        return ourPartnerComponentRepository.findAll().stream()
                .map(ourPartnerComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OurPartnerComponentResponse getOurPartnerComponentById(Long id) {
        OurPartnerComponent ourPartnerComponent = ourPartnerComponentRepository.findById(id).orElse(null);
        return ourPartnerComponent != null ? ourPartnerComponentMapper.toResponseDTO(ourPartnerComponent) : null;
    }

    @Override
    public OurPartnerComponentResponse createOurPartnerComponent(OurPartnerComponentRequest ourPartnerComponentDTO) {
        OurPartner ourPartner = ourPartnerRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new RuntimeException("OurPartner not found"));
        ourPartnerComponentDTO.setOurPartnerId(ourPartner.getId());

        OurPartnerComponent ourPartnerComponent = ourPartnerComponentMapper.toEntity(ourPartnerComponentDTO);
        OurPartnerComponent savedOurPartnerComponent = ourPartnerComponentRepository.save(ourPartnerComponent);
        return ourPartnerComponentMapper.toResponseDTO(savedOurPartnerComponent);
    }

    @Override
    public OurPartnerComponentResponse updateOurPartnerComponent(Long id, OurPartnerComponentRequest updatedOurPartnerComponentDTO) {
        OurPartnerComponent ourPartnerComponent = ourPartnerComponentRepository.findById(id).orElse(null);
        if (ourPartnerComponent != null) {
            ourPartnerComponent.setLogo(updatedOurPartnerComponentDTO.getLogo());
            ourPartnerComponent.setName(updatedOurPartnerComponentDTO.getName());
            OurPartnerComponent updatedOurPartnerComponent = ourPartnerComponentRepository.save(ourPartnerComponent);
            return ourPartnerComponentMapper.toResponseDTO(updatedOurPartnerComponent);
        }
        return null;
    }

    @Override
    public void deleteOurPartnerComponent(Long id) {
        ourPartnerComponentRepository.deleteById(id);
    }
}
