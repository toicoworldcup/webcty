package com.example.webcty.controllers;

import com.example.webcty.dto.request.AboutUsBannerRequest;
import com.example.webcty.dto.response.AboutUsBannerResponse;
import com.example.webcty.services.AboutUsBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about-us-banner")
public class AboutUsBannerController {
    private final AboutUsBannerService aboutUsBannerService;

    @Autowired
    public AboutUsBannerController(AboutUsBannerService aboutUsBannerService) {
        this.aboutUsBannerService = aboutUsBannerService;
    }

    @GetMapping
    public ResponseEntity<List<AboutUsBannerResponse>> getAllAboutUsBanner() {
        return ResponseEntity.ok(aboutUsBannerService.getAllAboutUsBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutUsBannerResponse> getAboutUsBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(aboutUsBannerService.getAboutUsBannerById(id));
    }

    @PostMapping
    public ResponseEntity<AboutUsBannerResponse> createAboutUsBanner(@RequestBody AboutUsBannerRequest aboutUsBanner) {
        return ResponseEntity.ok(aboutUsBannerService.createAboutUsBanner(aboutUsBanner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutUsBannerResponse> updateAboutUsBanner(@PathVariable Long id, @RequestBody AboutUsBannerRequest updateAboutUsBanner) {
        return ResponseEntity.ok(aboutUsBannerService.updateAboutUsBanner(id, updateAboutUsBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutUsBanner(@PathVariable Long id) {
        aboutUsBannerService.deleteAboutUsBanner(id);
        return ResponseEntity.noContent().build();
    }
}