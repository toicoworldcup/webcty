package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhyChooseUsComponentRequest;
import com.example.webcty.dto.response.WhyChooseUsComponentResponse;
import com.example.webcty.services.WhyChooseUsComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/why-choose-us-component")
public class WhyChooseUsComponentController {
    private final WhyChooseUsComponentService whyChooseUsComponentService;

    @Autowired
    public WhyChooseUsComponentController(WhyChooseUsComponentService whyChooseUsComponentService) {
        this.whyChooseUsComponentService = whyChooseUsComponentService;
    }

    @GetMapping
    public ResponseEntity<List<WhyChooseUsComponentResponse>> getAllWhyChooseUsComponent() {
        return ResponseEntity.ok(whyChooseUsComponentService.getAllWhyChooseUsComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhyChooseUsComponentResponse> getWhyChooseUsComponentById(@PathVariable Long id) {
        WhyChooseUsComponentResponse whyChooseUsComponent = whyChooseUsComponentService.getWhyChooseUsComponentById(id);
        return whyChooseUsComponent != null ? ResponseEntity.ok(whyChooseUsComponent) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<WhyChooseUsComponentResponse> createWhyChooseUsComponent(@RequestBody WhyChooseUsComponentRequest whyChooseUsComponent) {
        return ResponseEntity.ok(whyChooseUsComponentService.createWhyChooseUsComponent(whyChooseUsComponent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhyChooseUsComponentResponse> updateWhyChooseUsComponent(@PathVariable Long id, @RequestBody WhyChooseUsComponentRequest whyChooseUsComponent) {
        WhyChooseUsComponentResponse updatedWhyChooseUsComponent = whyChooseUsComponentService.updateWhyChooseUsComponent(id, whyChooseUsComponent);
        return updatedWhyChooseUsComponent != null ? ResponseEntity.ok(updatedWhyChooseUsComponent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhyChooseUsComponent(@PathVariable Long id) {
        whyChooseUsComponentService.deleteWhyChooseUsComponent(id);
        return ResponseEntity.noContent().build();
    }
}