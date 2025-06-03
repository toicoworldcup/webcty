package com.example.webcty.controllers;

import com.example.webcty.dto.request.HomeIntroRequest;
import com.example.webcty.dto.response.HomeIntroResponse;
import com.example.webcty.services.HomeIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home-intro")
public class HomeIntroController {
    private final HomeIntroService homeIntroService;

    @Autowired
    public HomeIntroController(HomeIntroService homeIntroService) {
        this.homeIntroService = homeIntroService;
    }

    @GetMapping
    public ResponseEntity<List<HomeIntroResponse>> getAllHomeIntro() {
        return ResponseEntity.ok(homeIntroService.getAllHomeIntro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeIntroResponse> getHomeIntroById(@PathVariable Long id) {
        return ResponseEntity.ok(homeIntroService.getHomeIntroById(id));
    }

    @PostMapping
    public ResponseEntity<HomeIntroResponse> createHomeIntro(@RequestBody HomeIntroRequest homeIntro) {
        return ResponseEntity.ok(homeIntroService.createHomeIntro(homeIntro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeIntroResponse> updateHomeIntro(@PathVariable Long id, @RequestBody HomeIntroRequest updateHomeIntro) {
        return ResponseEntity.ok(homeIntroService.updateHomeIntro(id, updateHomeIntro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomeIntro(@PathVariable Long id) {
        homeIntroService.deleteHomeIntro(id);
        return ResponseEntity.noContent().build();
    }
}