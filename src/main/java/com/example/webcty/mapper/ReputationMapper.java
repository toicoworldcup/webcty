package com.example.webcty.mapper;

import com.example.webcty.dto.request.ReputationRequest;
import com.example.webcty.dto.response.ReputationResponse;
import com.example.webcty.entities.aboutUsPage.Reputation;
import org.springframework.stereotype.Component;

@Component
public class ReputationMapper {
    public Reputation toEntity(ReputationRequest dto) {
        Reputation reputation = new Reputation();
        reputation.setTitle(dto.getTitle());
        reputation.setDescription(dto.getDescription());
        reputation.setIcon(dto.getIcon());
        return reputation;
    }

    public ReputationResponse toResponseDTO(Reputation entity) {
        ReputationResponse dto = new ReputationResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        return dto;
    }
}