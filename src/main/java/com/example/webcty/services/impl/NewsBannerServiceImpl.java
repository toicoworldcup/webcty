package com.example.webcty.services.impl;

import com.example.webcty.dto.request.NewsBannerRequest;
import com.example.webcty.dto.response.NewsBannerResponse;
import com.example.webcty.entities.newsPage.NewsBanner;
import com.example.webcty.mapper.NewsBannerMapper;
import com.example.webcty.repositories.NewsBannerRepository;
import com.example.webcty.services.NewsBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsBannerServiceImpl implements NewsBannerService {
    private final NewsBannerRepository newsBannerRepository;
    private final NewsBannerMapper newsBannerMapper;

    @Autowired
    public NewsBannerServiceImpl(NewsBannerRepository newsBannerRepository, NewsBannerMapper newsBannerMapper) {
        this.newsBannerRepository = newsBannerRepository;
        this.newsBannerMapper = newsBannerMapper;
    }

    @Override
    public List<NewsBannerResponse> getAllNewsBanner() {
        return newsBannerRepository.findAll().stream()
                .map(newsBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NewsBannerResponse getNewsBannerById(Long id) {
        NewsBanner newsBanner = newsBannerRepository.findById(id).orElse(null);
        return newsBanner != null ? newsBannerMapper.toResponseDTO(newsBanner) : null;
    }

    @Override
    @Transactional
    public NewsBannerResponse createNewsBanner(NewsBannerRequest newsBannerDTO) {
        newsBannerRepository.deleteAll();
        NewsBanner newsBanner = newsBannerMapper.toEntity(newsBannerDTO);
        NewsBanner savedNewsBanner = newsBannerRepository.save(newsBanner);
        return newsBannerMapper.toResponseDTO(savedNewsBanner);
    }

    @Override
    public NewsBannerResponse updateNewsBanner(Long id, NewsBannerRequest updatedNewsBannerDTO) {
        NewsBanner newsBanner = newsBannerRepository.findById(id).orElse(null);
        if (newsBanner != null) {
            newsBanner.setSlogan(updatedNewsBannerDTO.getSlogan());
            newsBanner.setImage(updatedNewsBannerDTO.getImage());
            NewsBanner updatedNewsBanner = newsBannerRepository.save(newsBanner);
            return newsBannerMapper.toResponseDTO(updatedNewsBanner);
        }
        return null;
    }

    @Override
    public void deleteNewsBanner(Long id) {
        newsBannerRepository.deleteById(id);
    }
}
