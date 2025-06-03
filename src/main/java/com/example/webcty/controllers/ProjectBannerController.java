package com.example.webcty.controllers;

import com.example.webcty.dto.request.ProjectBannerRequest;
import com.example.webcty.dto.response.ProjectBannerResponse;
import com.example.webcty.services.ProjectBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-banner")
public class ProjectBannerController {
    private final ProjectBannerService projectBannerService;

    @Autowired
    public ProjectBannerController(ProjectBannerService projectBannerService) {
        this.projectBannerService = projectBannerService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectBannerResponse>> getAllProjectBanner() {
        return ResponseEntity.ok(projectBannerService.getAllProjectBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectBannerResponse> getProjectBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(projectBannerService.getProjectBannerById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectBannerResponse> createProjectBanner(@RequestBody ProjectBannerRequest projectBanner) {
        return ResponseEntity.ok(projectBannerService.createProjectBanner(projectBanner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectBannerResponse> updateProjectBanner(@PathVariable Long id, @RequestBody ProjectBannerRequest updateProjectBanner) {
        return ResponseEntity.ok(projectBannerService.updateProjectBanner(id, updateProjectBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectBanner(@PathVariable Long id) {
        projectBannerService.deleteProjectBanner(id);
        return ResponseEntity.noContent().build();
    }
}