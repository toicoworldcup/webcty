package com.example.webcty.controllers;

import com.example.webcty.entities.AboutUs;
import com.example.webcty.services.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about-us")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping
    public ResponseEntity<List<AboutUs>> getAllAboutUs() {
        return ResponseEntity.ok(aboutUsService.getAllAboutUs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutUs> getAboutUsById(@PathVariable Long id) {
        return ResponseEntity.ok(aboutUsService.getAboutUsById(id));
    }

    @PostMapping
    public ResponseEntity<AboutUs> createAboutUs(@RequestBody AboutUs aboutUs) {
        return ResponseEntity.ok(aboutUsService.createAboutUs(aboutUs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutUs> updateCompanyInfo(@PathVariable Long id, @RequestBody AboutUs updateAboutUs) {
        return ResponseEntity.ok(aboutUsService.updateAboutUs(id, updateAboutUs));    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutUs(@PathVariable Long id) {
        aboutUsService.deleteAboutUs(id);
        return ResponseEntity.noContent().build();
    }
}
