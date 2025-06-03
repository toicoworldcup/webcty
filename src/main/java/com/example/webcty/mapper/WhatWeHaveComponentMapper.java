package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhatWeHaveComponentRequest;
import com.example.webcty.dto.response.WhatWeHaveComponentResponse;
import com.example.webcty.entities.homePage.WhatWeHaveComponent;
import org.springframework.stereotype.Component;

@Component
public class WhatWeHaveComponentMapper {
    public WhatWeHaveComponent toEntity(WhatWeHaveComponentRequest dto) {
        WhatWeHaveComponent whatWeHaveComponent = new WhatWeHaveComponent();
        whatWeHaveComponent.setTitle(dto.getTitle());
        whatWeHaveComponent.setDescription(dto.getDescription());
        whatWeHaveComponent.setImage(dto.getImage());
        whatWeHaveComponent.setTags(dto.getTags());
        return whatWeHaveComponent;
    }

    public WhatWeHaveComponentResponse toResponseDTO(WhatWeHaveComponent entity) {
        WhatWeHaveComponentResponse dto = new WhatWeHaveComponentResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setTags(entity.getTags());
        return dto;
    }
}