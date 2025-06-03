package com.example.webcty.controllers;

import com.example.webcty.dto.request.HomeBannerRequest;
import com.example.webcty.dto.response.HomeBannerResponse;
import com.example.webcty.services.HomeBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home-banner")
public class HomeBannerController {
    private final HomeBannerService homeBannerService;

    @Autowired
    public HomeBannerController(HomeBannerService homeBannerService) {
        this.homeBannerService = homeBannerService;
    }

    @GetMapping
    public ResponseEntity<List<HomeBannerResponse>> getAllHomeBanner() {
        return ResponseEntity.ok(homeBannerService.getAllHomeBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeBannerResponse> getHomeBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(homeBannerService.getHomeBannerById(id));
    }

    @PostMapping
    public ResponseEntity<HomeBannerResponse> createHomeBanner(@RequestBody HomeBannerRequest banner) {
        return ResponseEntity.ok(homeBannerService.createHomeBanner(banner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeBannerResponse> updateHomeBanner(@PathVariable Long id, @RequestBody HomeBannerRequest updateBanner) {
        return ResponseEntity.ok(homeBannerService.updateHomeBanner(id, updateBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomeBanner(@PathVariable Long id) {
        homeBannerService.deleteHomeBanner(id);
        return ResponseEntity.noContent().build();
    }
}