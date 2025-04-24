package com.example.webcty.controllers;

import com.example.webcty.dto.request.BannerRequest;
import com.example.webcty.dto.response.BannerResponse;
import com.example.webcty.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
public class BannerController {
    private final BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public ResponseEntity<List<BannerResponse>> getAllBanners() {
        return ResponseEntity.ok(bannerService.getAllBanners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BannerResponse> getBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(bannerService.getBannerById(id));
    }

    @PostMapping
    public ResponseEntity<BannerResponse> createBanner(@RequestBody BannerRequest banner) {
        return ResponseEntity.ok(bannerService.createBanner(banner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BannerResponse> updateBanner(@PathVariable Long id, @RequestBody BannerRequest updateBanner) {
        return ResponseEntity.ok(bannerService.updateBanner(id, updateBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanner(@PathVariable Long id) {
        bannerService.deleteBanner(id);
        return ResponseEntity.noContent().build();
    }
}