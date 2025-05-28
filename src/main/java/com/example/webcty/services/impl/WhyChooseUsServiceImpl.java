package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhyChooseUsRequest;
import com.example.webcty.dto.response.WhyChooseUsResponse;
import com.example.webcty.entities.homePage.WhyChooseUs;
import com.example.webcty.mapper.WhyChooseUsMapper;
import com.example.webcty.repositories.WhyChooseUsRepository;
import com.example.webcty.services.WhyChooseUsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhyChooseUsServiceImpl implements WhyChooseUsService {
    private final WhyChooseUsRepository whyChooseUsRepository;
    private final WhyChooseUsMapper whyChooseUsMapper;

    @Autowired
    public WhyChooseUsServiceImpl(WhyChooseUsRepository whyChooseUsRepository, WhyChooseUsMapper whyChooseUsMapper) {
        this.whyChooseUsRepository = whyChooseUsRepository;
        this.whyChooseUsMapper = whyChooseUsMapper;
    }

    @Override
    public List<WhyChooseUsResponse> getAllWhyChooseUs() {
        return whyChooseUsRepository.findAll().stream()
                .map(whyChooseUsMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhyChooseUsResponse getWhyChooseUsById(Long id) {
        WhyChooseUs whyChooseUs = whyChooseUsRepository.findById(id).orElse(null);
        return whyChooseUs != null ? whyChooseUsMapper.toResponseDTO(whyChooseUs) : null;
    }

    @Override
    @Transactional
    public WhyChooseUsResponse createWhyChooseUs(WhyChooseUsRequest whyChooseUsDTO) {
        whyChooseUsRepository.deleteAll();
        WhyChooseUs whyChooseUs = whyChooseUsMapper.toEntity(whyChooseUsDTO);
        WhyChooseUs savedWhyChooseUs = whyChooseUsRepository.save(whyChooseUs);
        return whyChooseUsMapper.toResponseDTO(savedWhyChooseUs);
    }

    @Override
    public WhyChooseUsResponse updateWhyChooseUs(Long id, WhyChooseUsRequest updatedWhyChooseUsDTO) {
        WhyChooseUs whyChooseUs = whyChooseUsRepository.findById(id).orElse(null);
        if (whyChooseUs != null) {
            whyChooseUs.setTitle(updatedWhyChooseUsDTO.getTitle());
            whyChooseUs.setDescription(updatedWhyChooseUsDTO.getDescription());
            WhyChooseUs updatedWhyChooseUs = whyChooseUsRepository.save(whyChooseUs);
            return whyChooseUsMapper.toResponseDTO(updatedWhyChooseUs);
        }
        return null;
    }

    @Override
    public void deleteWhyChooseUs(Long id) {
        whyChooseUsRepository.deleteById(id);
    }
}
