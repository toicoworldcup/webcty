package com.example.webcty.controllers;

import com.example.webcty.dto.request.TechnologyRequest;
import com.example.webcty.dto.response.TechnologyResponse;
import com.example.webcty.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologys() {
        return ResponseEntity.ok(technologyService.getAllTechnologys());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponse> getTechnologyById(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.getTechnologyById(id));
    }

    @PostMapping
    public ResponseEntity<TechnologyResponse> createTechnology(@RequestBody TechnologyRequest technology) {
        return ResponseEntity.ok(technologyService.createTechnology(technology));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponse> updateTechnology(@PathVariable Long id, @RequestBody TechnologyRequest updateTechnology) {
        return ResponseEntity.ok(technologyService.updateTechnology(id, updateTechnology));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}