package com.example.webcty.controllers;

import com.example.webcty.dto.request.AboutUsRequest;
import com.example.webcty.dto.response.AboutUsResponse;
import com.example.webcty.services.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about-us")
public class AboutUsController {
    private final AboutUsService aboutUsService;

    @Autowired
    public AboutUsController(AboutUsService aboutUsService) {
        this.aboutUsService = aboutUsService;
    }

    @GetMapping
    public ResponseEntity<List<AboutUsResponse>> getAllaboutUs() {
        return ResponseEntity.ok(aboutUsService.getAllAboutUs());
    }

    @PostMapping
    public ResponseEntity<AboutUsResponse> createAboutUs(@RequestBody AboutUsRequest aboutUs) {
        return ResponseEntity.ok(aboutUsService.createAboutUs(aboutUs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutUsResponse> updateAboutUs(@PathVariable Long id, @RequestBody AboutUsRequest updateAboutUs) {
        return ResponseEntity.ok(aboutUsService.updateAboutUs(id, updateAboutUs));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutUs(@PathVariable Long id) {
        aboutUsService.deleteAboutUs(id);
        return ResponseEntity.noContent().build();
    }
}