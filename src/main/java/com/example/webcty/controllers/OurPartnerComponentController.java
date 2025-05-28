package com.example.webcty.controllers;

import com.example.webcty.dto.request.OurPartnerComponentRequest;
import com.example.webcty.dto.response.OurPartnerComponentResponse;
import com.example.webcty.services.OurPartnerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/our-partner-component")
public class OurPartnerComponentController {
    private final OurPartnerComponentService ourPartnerComponentService;

    @Autowired
    public OurPartnerComponentController(OurPartnerComponentService ourPartnerComponentService) {
        this.ourPartnerComponentService = ourPartnerComponentService;
    }

    @GetMapping
    public ResponseEntity<List<OurPartnerComponentResponse>> getAllOurPartnerComponent() {
        return ResponseEntity.ok(ourPartnerComponentService.getAllOurPartnerComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OurPartnerComponentResponse> getOurPartnerComponentById(@PathVariable Long id) {
        return ResponseEntity.ok(ourPartnerComponentService.getOurPartnerComponentById(id));
    }

    @PostMapping
    public ResponseEntity<OurPartnerComponentResponse> createOurPartnerComponent(@RequestBody OurPartnerComponentRequest ourPartnerComponent) {
        return ResponseEntity.ok(ourPartnerComponentService.createOurPartnerComponent(ourPartnerComponent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OurPartnerComponentResponse> updateOurPartnerComponent(@PathVariable Long id, @RequestBody OurPartnerComponentRequest updateourPartnerComponent) {
        return ResponseEntity.ok(ourPartnerComponentService.updateOurPartnerComponent(id, updateourPartnerComponent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOurPartnerComponent(@PathVariable Long id) {
        ourPartnerComponentService.deleteOurPartnerComponent(id);
        return ResponseEntity.noContent().build();
    }
}