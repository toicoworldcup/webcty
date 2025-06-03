package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ReputationRequest;
import com.example.webcty.dto.response.ReputationResponse;
import com.example.webcty.entities.aboutUsPage.Reputation;
import com.example.webcty.mapper.ReputationMapper;
import com.example.webcty.repositories.ReputationRepository;
import com.example.webcty.services.ReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReputationServiceImpl implements ReputationService {
    private final ReputationRepository reputationRepository;
    private final ReputationMapper reputationMapper;

    @Autowired
    public ReputationServiceImpl(ReputationRepository reputationRepository, ReputationMapper reputationMapper) {
        this.reputationRepository = reputationRepository;
        this.reputationMapper = reputationMapper;
    }

    @Override
    public List<ReputationResponse> getAllReputation() {
        return reputationRepository.findAll().stream()
                .map(reputationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReputationResponse getReputationById(Long id) {
        Reputation reputation = reputationRepository.findById(id).orElse(null);
        return reputation != null ? reputationMapper.toResponseDTO(reputation) : null;
    }

    @Override
    public ReputationResponse createReputation(ReputationRequest reputationDTO) {
        Reputation reputation = reputationMapper.toEntity(reputationDTO);
        Reputation savedReputation = reputationRepository.save(reputation);
        return reputationMapper.toResponseDTO(savedReputation);
    }

    @Override
    public ReputationResponse updateReputation(Long id, ReputationRequest updatedreputationDTO) {
        Reputation reputation = reputationRepository.findById(id).orElse(null);
        if (reputation != null) {
            reputation.setTitle(updatedreputationDTO.getTitle());
            reputation.setDescription(updatedreputationDTO.getDescription());
            reputation.setIcon(updatedreputationDTO.getIcon());
            Reputation updatedReputation = reputationRepository.save(reputation);
            return reputationMapper.toResponseDTO(updatedReputation);
        }
        return null;
    }

    @Override
    public void deleteReputation(Long id) {
        reputationRepository.deleteById(id);
    }
}
