package com.example.webcty.controllers;

import com.example.webcty.dto.request.NewsBannerRequest;
import com.example.webcty.dto.response.NewsBannerResponse;
import com.example.webcty.services.NewsBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news-banner")
public class NewsBannerController {
    private final NewsBannerService NewsBannerService;

    @Autowired
    public NewsBannerController(NewsBannerService NewsBannerService) {
        this.NewsBannerService = NewsBannerService;
    }

    @GetMapping
    public ResponseEntity<List<NewsBannerResponse>> getAllNewsBanner() {
        return ResponseEntity.ok(NewsBannerService.getAllNewsBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsBannerResponse> getNewsBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(NewsBannerService.getNewsBannerById(id));
    }

    @PostMapping
    public ResponseEntity<NewsBannerResponse> createNewsBanner(@RequestBody NewsBannerRequest newsBanner) {
        return ResponseEntity.ok(NewsBannerService.createNewsBanner(newsBanner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsBannerResponse> updateNewsBanner(@PathVariable Long id, @RequestBody NewsBannerRequest updateNewsBanner) {
        return ResponseEntity.ok(NewsBannerService.updateNewsBanner(id, updateNewsBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsBanner(@PathVariable Long id) {
        NewsBannerService.deleteNewsBanner(id);
        return ResponseEntity.noContent().build();
    }
}