package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhoWeAreRequest;
import com.example.webcty.dto.response.WhoWeAreResponse;
import com.example.webcty.services.WhoWeAreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/who-we-are")
public class WhoWeAreController {
    private final WhoWeAreService whoWeAreService;

    @Autowired
    public WhoWeAreController(WhoWeAreService whoWeAreService) {
        this.whoWeAreService = whoWeAreService;
    }

    @GetMapping
    public ResponseEntity<List<WhoWeAreResponse>> getAllWhoWeAre() {
        return ResponseEntity.ok(whoWeAreService.getAllWhoWeAre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhoWeAreResponse> getWhoWeAreById(@PathVariable Long id) {
        return ResponseEntity.ok(whoWeAreService.getWhoWeAreById(id));
    }

    @PostMapping
    public ResponseEntity<WhoWeAreResponse> createWhoWeAre(@RequestBody WhoWeAreRequest whoWeAre) {
        return ResponseEntity.ok(whoWeAreService.createWhoWeAre(whoWeAre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhoWeAreResponse> updateWhoWeAre(@PathVariable Long id, @RequestBody WhoWeAreRequest updateWhoWeAre) {
        return ResponseEntity.ok(whoWeAreService.updateWhoWeAre(id, updateWhoWeAre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhoWeAre(@PathVariable Long id) {
        whoWeAreService.deleteWhoWeAre(id);
        return ResponseEntity.noContent().build();
    }
}