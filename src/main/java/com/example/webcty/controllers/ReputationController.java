package com.example.webcty.controllers;

import com.example.webcty.dto.request.ReputationRequest;
import com.example.webcty.dto.response.ReputationResponse;
import com.example.webcty.services.ReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reputation")
public class ReputationController {
    private final ReputationService reputationService;

    @Autowired
    public ReputationController(ReputationService reputationService) {
        this.reputationService = reputationService;
    }

    @GetMapping
    public ResponseEntity<List<ReputationResponse>> getAllReputation() {
        return ResponseEntity.ok(reputationService.getAllReputation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReputationResponse> getReputationById(@PathVariable Long id) {
        return ResponseEntity.ok(reputationService.getReputationById(id));
    }

    @PostMapping
    public ResponseEntity<ReputationResponse> createReputation(@RequestBody ReputationRequest reputation) {
        return ResponseEntity.ok(reputationService.createReputation(reputation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReputationResponse> updateReputation(@PathVariable Long id, @RequestBody ReputationRequest updateReputation) {
        return ResponseEntity.ok(reputationService.updateReputation(id, updateReputation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReputation(@PathVariable Long id) {
        reputationService.deleteReputation(id);
        return ResponseEntity.noContent().build();
    }
}