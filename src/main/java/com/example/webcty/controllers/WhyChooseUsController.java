package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhyChooseUsRequest;
import com.example.webcty.dto.response.WhyChooseUsResponse;
import com.example.webcty.services.WhyChooseUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/why-choose-us")
public class WhyChooseUsController {
    private final WhyChooseUsService whyChooseUsService;

    @Autowired
    public WhyChooseUsController(WhyChooseUsService whyChooseUsService) {
        this.whyChooseUsService = whyChooseUsService;
    }

    @GetMapping
    public ResponseEntity<List<WhyChooseUsResponse>> getAllWhyChooseUs() {
        return ResponseEntity.ok(whyChooseUsService.getAllWhyChooseUs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhyChooseUsResponse> getWhyChooseUsById(@PathVariable Long id) {
        return ResponseEntity.ok(whyChooseUsService.getWhyChooseUsById(id));
    }

    @PostMapping
    public ResponseEntity<WhyChooseUsResponse> createWhyChooseUs(@RequestBody WhyChooseUsRequest whyChooseUs) {
        return ResponseEntity.ok(whyChooseUsService.createWhyChooseUs(whyChooseUs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhyChooseUsResponse> updateWhyChooseUs(@PathVariable Long id, @RequestBody WhyChooseUsRequest updateWhyChooseUs) {
        return ResponseEntity.ok(whyChooseUsService.updateWhyChooseUs(id, updateWhyChooseUs));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhyChooseUs(@PathVariable Long id) {
        whyChooseUsService.deleteWhyChooseUs(id);
        return ResponseEntity.noContent().build();
    }
}