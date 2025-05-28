package com.example.webcty.controllers;

import com.example.webcty.dto.request.FeatureServiceComponentRequest;
import com.example.webcty.dto.response.FeatureServiceComponentResponse;
import com.example.webcty.services.FeatureServiceComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feature-service-component")
public class FeatureServiceComponentController {
    private final FeatureServiceComponentService featureServiceComponentService;

    @Autowired
    public FeatureServiceComponentController(FeatureServiceComponentService featureServiceComponentService) {
        this.featureServiceComponentService = featureServiceComponentService;
    }

    @GetMapping
    public ResponseEntity<List<FeatureServiceComponentResponse>> getAllFeatureServiceComponent() {
        return ResponseEntity.ok(featureServiceComponentService.getAllFeatureServiceComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureServiceComponentResponse> getFeatureServiceComponentById(@PathVariable Long id) {
        FeatureServiceComponentResponse featureServiceComponent = featureServiceComponentService.getFeatureServiceComponentById(id);
        return featureServiceComponent != null ? ResponseEntity.ok(featureServiceComponent) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FeatureServiceComponentResponse> createFeatureServiceComponent(@RequestBody FeatureServiceComponentRequest featureServiceComponent) {
        return ResponseEntity.ok(featureServiceComponentService.createFeatureServiceComponent(featureServiceComponent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureServiceComponentResponse> updateFeatureServiceComponent(@PathVariable Long id, @RequestBody FeatureServiceComponentRequest featureServiceComponent) {
        FeatureServiceComponentResponse updatedFeatureServiceComponent = featureServiceComponentService.updateFeatureServiceComponent(id, featureServiceComponent);
        return updatedFeatureServiceComponent != null ? ResponseEntity.ok(updatedFeatureServiceComponent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeatureServiceComponent(@PathVariable Long id) {
        featureServiceComponentService.deleteFeatureServiceComponent(id);
        return ResponseEntity.noContent().build();
    }
}