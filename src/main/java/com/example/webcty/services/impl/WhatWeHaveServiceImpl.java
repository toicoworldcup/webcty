package com.example.webcty.services.impl;

import com.example.webcty.dto.request.WhatWeHaveRequest;
import com.example.webcty.dto.response.WhatWeHaveResponse;
import com.example.webcty.entities.homePage.WhatWeHave;
import com.example.webcty.mapper.WhatWeHaveMapper;
import com.example.webcty.repositories.WhatWeHaveRepository;
import com.example.webcty.services.WhatWeHaveService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhatWeHaveServiceImpl implements WhatWeHaveService {
    private final WhatWeHaveRepository whatWeHaveRepository;
    private final WhatWeHaveMapper whatWeHaveMapper;

    @Autowired
    public WhatWeHaveServiceImpl(WhatWeHaveRepository whatWeHaveRepository, WhatWeHaveMapper whatWeHaveMapper) {
        this.whatWeHaveRepository = whatWeHaveRepository;
        this.whatWeHaveMapper = whatWeHaveMapper;
    }

    @Override
    public List<WhatWeHaveResponse> getAllWhatWeHave() {
        return whatWeHaveRepository.findAll().stream()
                .map(whatWeHaveMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WhatWeHaveResponse getWhatWeHaveById(Long id) {
        WhatWeHave whatWeHave = whatWeHaveRepository.findById(id).orElse(null);
        return whatWeHave != null ? whatWeHaveMapper.toResponseDTO(whatWeHave) : null;
    }

    @Override
    @Transactional
    public WhatWeHaveResponse createWhatWeHave(WhatWeHaveRequest whatWeHaveDTO) {
        whatWeHaveRepository.deleteAll();
        WhatWeHave whatWeHave = whatWeHaveMapper.toEntity(whatWeHaveDTO);
        WhatWeHave savedWhatWeHave = whatWeHaveRepository.save(whatWeHave);
        return whatWeHaveMapper.toResponseDTO(savedWhatWeHave);
    }

    @Override
    public WhatWeHaveResponse updateWhatWeHave(Long id, WhatWeHaveRequest updatedWhatWeHaveDTO) {
        WhatWeHave whatWeHave = whatWeHaveRepository.findById(id).orElse(null);
        if (whatWeHave != null) {
            whatWeHave.setTitle(updatedWhatWeHaveDTO.getTitle());
            whatWeHave.setDescription(updatedWhatWeHaveDTO.getDescription());
            WhatWeHave updatedWhatWeHave = whatWeHaveRepository.save(whatWeHave);
            return whatWeHaveMapper.toResponseDTO(updatedWhatWeHave);
        }
        return null;
    }

    @Override
    public void deleteWhatWeHave(Long id) {
        whatWeHaveRepository.deleteById(id);
    }
}
