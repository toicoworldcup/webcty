package com.example.webcty.controllers;

import com.example.webcty.dto.request.AboutUsIntroRequest;
import com.example.webcty.dto.response.AboutUsIntroResponse;
import com.example.webcty.services.AboutUsIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about-us-intro")
public class AboutUsIntroController {
    private final AboutUsIntroService aboutUsIntroService;

    @Autowired
    public AboutUsIntroController(AboutUsIntroService aboutUsIntroService) {
        this.aboutUsIntroService = aboutUsIntroService;
    }

    @GetMapping
    public ResponseEntity<List<AboutUsIntroResponse>> getAllAboutUsIntro() {
        return ResponseEntity.ok(aboutUsIntroService.getAllAboutUsIntro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutUsIntroResponse> getAboutUsIntroById(@PathVariable Long id) {
        return ResponseEntity.ok(aboutUsIntroService.getAboutUsIntroById(id));
    }

    @PostMapping
    public ResponseEntity<AboutUsIntroResponse> createAboutUsIntro(@RequestBody AboutUsIntroRequest aboutUsIntro) {
        return ResponseEntity.ok(aboutUsIntroService.createAboutUsIntro(aboutUsIntro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutUsIntroResponse> updateAboutUsIntro(@PathVariable Long id, @RequestBody AboutUsIntroRequest updateAboutUsIntro) {
        return ResponseEntity.ok(aboutUsIntroService.updateAboutUsIntro(id, updateAboutUsIntro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutUsIntro(@PathVariable Long id) {
        aboutUsIntroService.deleteAboutUsIntro(id);
        return ResponseEntity.noContent().build();
    }
}