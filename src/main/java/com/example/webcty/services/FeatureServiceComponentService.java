package com.example.webcty.services;

import com.example.webcty.dto.request.FeatureServiceComponentRequest;
import com.example.webcty.dto.response.FeatureServiceComponentResponse;

import java.util.List;

public interface FeatureServiceComponentService {
    List<FeatureServiceComponentResponse> getAllFeatureServiceComponent();

    FeatureServiceComponentResponse getFeatureServiceComponentById(Long id);

    FeatureServiceComponentResponse createFeatureServiceComponent(FeatureServiceComponentRequest featureServiceComponent);

    FeatureServiceComponentResponse updateFeatureServiceComponent(Long id, FeatureServiceComponentRequest updatedFeatureServiceComponent);

    void deleteFeatureServiceComponent(Long id);
}
