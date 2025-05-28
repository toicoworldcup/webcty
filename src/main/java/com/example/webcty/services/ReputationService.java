package com.example.webcty.services;

import com.example.webcty.dto.request.ReputationRequest;
import com.example.webcty.dto.response.ReputationResponse;

import java.util.List;

public interface ReputationService {
    List<ReputationResponse> getAllReputation();

    ReputationResponse getReputationById(Long id);

    ReputationResponse createReputation(ReputationRequest reputation);

    ReputationResponse updateReputation(Long id, ReputationRequest updatedReputation);

    void deleteReputation(Long id);
}
