package com.example.webcty.mapper;

import com.example.webcty.dto.request.WhatWeHaveRequest;
import com.example.webcty.dto.response.WhatWeHaveResponse;
import com.example.webcty.entities.homePage.WhatWeHave;
import org.springframework.stereotype.Component;

@Component
public class WhatWeHaveMapper {
    public WhatWeHave toEntity(WhatWeHaveRequest dto) {
        WhatWeHave whatWeHave = new WhatWeHave();
        whatWeHave.setTitle(dto.getTitle());
        whatWeHave.setDescription(dto.getDescription());
        return whatWeHave;
    }

    public WhatWeHaveResponse toResponseDTO(WhatWeHave entity) {
        WhatWeHaveResponse dto = new WhatWeHaveResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}