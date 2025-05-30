package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhoWeAreComponentRequest;
import com.example.webcty.dto.response.WhoWeAreComponentResponse;
import com.example.webcty.services.WhoWeAreComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/who-we-are-component")
public class WhoWeAreComponentController {
    private final WhoWeAreComponentService whoWeAreComponentService;

    @Autowired
    public WhoWeAreComponentController(WhoWeAreComponentService whoWeAreComponentService) {
        this.whoWeAreComponentService = whoWeAreComponentService;
    }

    @GetMapping
    public ResponseEntity<List<WhoWeAreComponentResponse>> getAllWhoWeAreComponent() {
        return ResponseEntity.ok(whoWeAreComponentService.getAllWhoWeAreComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhoWeAreComponentResponse> getWhoWeAreComponentById(@PathVariable Long id) {
        return ResponseEntity.ok(whoWeAreComponentService.getWhoWeAreComponentById(id));
    }

    @PostMapping
    public ResponseEntity<WhoWeAreComponentResponse> createWhoWeAreComponent(@RequestBody WhoWeAreComponentRequest whoWeAreComponent) {
        return ResponseEntity.ok(whoWeAreComponentService.createWhoWeAreComponent(whoWeAreComponent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhoWeAreComponentResponse> updateWhoWeAreComponent(@PathVariable Long id, @RequestBody WhoWeAreComponentRequest updateWhoWeAreComponent) {
        return ResponseEntity.ok(whoWeAreComponentService.updateWhoWeAreComponent(id, updateWhoWeAreComponent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhoWeAreComponent(@PathVariable Long id) {
        whoWeAreComponentService.deleteWhoWeAreComponent(id);
        return ResponseEntity.noContent().build();
    }
}