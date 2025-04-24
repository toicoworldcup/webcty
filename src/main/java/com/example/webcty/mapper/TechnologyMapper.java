package com.example.webcty.mapper;

import com.example.webcty.dto.request.TechnologyRequest;
import com.example.webcty.dto.response.TechnologyResponse;
import com.example.webcty.entities.Technology;
import org.springframework.stereotype.Component;

@Component
public class TechnologyMapper {
    public Technology toEntity(TechnologyRequest dto) {
        Technology technology = new Technology();
        technology.setTitle(dto.getTitle());
        technology.setDescription(dto.getDescription());
        technology.setImage(dto.getImage());
        technology.setCreatedBy("admin"); // Mặc định created_by là admin
        return technology;
    }

    public TechnologyResponse toResponseDTO(Technology entity) {
        TechnologyResponse dto = new TechnologyResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        return dto;
    }
}