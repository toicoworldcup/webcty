package com.example.webcty.controllers;

import com.example.webcty.dto.request.FeatureServiceRequest;
import com.example.webcty.dto.response.FeatureServiceResponse;
import com.example.webcty.services.FeatureServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feature-service")
public class FeatureServiceController {
    private final FeatureServiceService featureServiceService;

    @Autowired
    public FeatureServiceController(FeatureServiceService featureServiceService) {
        this.featureServiceService = featureServiceService;
    }

    @GetMapping
    public ResponseEntity<List<FeatureServiceResponse>> getAllFeatureService() {
        return ResponseEntity.ok(featureServiceService.getAllFeatureService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureServiceResponse> getFeatureServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(featureServiceService.getFeatureServiceById(id));
    }

    @PostMapping
    public ResponseEntity<FeatureServiceResponse> createFeatureService(@RequestBody FeatureServiceRequest featureService) {
        return ResponseEntity.ok(featureServiceService.createFeatureService(featureService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureServiceResponse> updateFeatureService(@PathVariable Long id, @RequestBody FeatureServiceRequest updateFeatureService) {
        return ResponseEntity.ok(featureServiceService.updateFeatureService(id, updateFeatureService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeatureService(@PathVariable Long id) {
        featureServiceService.deleteFeatureService(id);
        return ResponseEntity.noContent().build();
    }
}