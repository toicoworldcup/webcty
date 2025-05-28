package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhatWeHaveComponentRequest;
import com.example.webcty.dto.response.WhatWeHaveComponentResponse;
import com.example.webcty.dto.response.WhatWeHaveResponse;
import com.example.webcty.entities.homePage.WhatWeHaveComponent;
import com.example.webcty.entities.homePage.WhatWeHave;
import com.example.webcty.repositories.WhatWeHaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhatWeHaveComponentMapper {
    private final WhatWeHaveRepository whatWeHaveRepository;
    private final WhatWeHaveMapper whatWeHaveMapper;

    @Autowired
    public WhatWeHaveComponentMapper(WhatWeHaveRepository whatWeHaveRepository, WhatWeHaveMapper whatWeHaveMapper) {
        this.whatWeHaveRepository = whatWeHaveRepository;
        this.whatWeHaveMapper = whatWeHaveMapper;
    }
    public WhatWeHaveComponent toEntity(WhatWeHaveComponentRequest dto) {
        WhatWeHaveComponent whatWeHaveComponent = new WhatWeHaveComponent();
        whatWeHaveComponent.setTitle(dto.getTitle());
        whatWeHaveComponent.setDescription(dto.getDescription());
        whatWeHaveComponent.setImage(dto.getImage());

        WhatWeHave whatWeHave = whatWeHaveRepository.findById(dto.getWhatWeHaveId())
                .orElseThrow(() -> new RuntimeException("WhatWeHave not found"));
        whatWeHaveComponent.setWhatWeHave(whatWeHave);

        whatWeHaveComponent.setTags(dto.getTags());
        whatWeHaveComponent.setCreatedBy("admin"); // Mặc định created_by là admin
        return whatWeHaveComponent;
    }

    public WhatWeHaveComponentResponse toResponseDTO(WhatWeHaveComponent entity) {
        WhatWeHaveComponentResponse dto = new WhatWeHaveComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        WhatWeHave whatWeHave = entity.getWhatWeHave();
        WhatWeHaveResponse whatWeHaveDTO = whatWeHaveMapper.toResponseDTO(whatWeHave);
        dto.setWhatWeHave(whatWeHaveDTO);
        dto.setTags(entity.getTags());
        return dto;
    }
}