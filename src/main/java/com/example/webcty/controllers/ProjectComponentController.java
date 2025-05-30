package com.example.webcty.controllers;

import com.example.webcty.dto.request.ProjectComponentRequest;
import com.example.webcty.dto.response.ProjectComponentResponse;
import com.example.webcty.services.ProjectComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-component")
public class ProjectComponentController {
    private final ProjectComponentService projectComponentService;

    @Autowired
    public ProjectComponentController(ProjectComponentService projectComponentService) {
        this.projectComponentService = projectComponentService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectComponentResponse>> getAllProjectComponent () {
        return ResponseEntity.ok(projectComponentService.getAllProjectComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectComponentResponse> getProjectComponentById(@PathVariable Long id) {
        return ResponseEntity.ok(projectComponentService.getProjectComponentById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectComponentResponse> createProjectComponent(@RequestBody ProjectComponentRequest projectComponent) {
        return ResponseEntity.ok(projectComponentService.createProjectComponent(projectComponent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectComponentResponse> updateProjectComponent(@PathVariable Long id, @RequestBody ProjectComponentRequest updatedProjectComponent) {
        return ResponseEntity.ok(projectComponentService.updateProjectComponent(id, updatedProjectComponent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectComponent(@PathVariable Long id) {
        projectComponentService.deleteProjectComponent(id);
        return ResponseEntity.noContent().build();
    }
}