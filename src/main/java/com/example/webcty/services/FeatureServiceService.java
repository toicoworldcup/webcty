package com.example.webcty.services;

import com.example.webcty.dto.request.FeatureServiceRequest;
import com.example.webcty.dto.response.FeatureServiceResponse;

import java.util.List;

public interface FeatureServiceService {
    List<FeatureServiceResponse> getAllFeatureService();

    FeatureServiceResponse getFeatureServiceById(Long id);

    FeatureServiceResponse createFeatureService(FeatureServiceRequest featureService);

    FeatureServiceResponse updateFeatureService(Long id, FeatureServiceRequest updatedFeatureService);

    void deleteFeatureService(Long id);
}
