package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyExperienceRequest;
import com.example.webcty.dto.response.CompanyExperienceResponse;
import com.example.webcty.services.CompanyExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-experiences")
public class CompanyExperienceController {
    private final CompanyExperienceService companyExperienceService;

    @Autowired
    public CompanyExperienceController(CompanyExperienceService companyExperienceService) {
        this.companyExperienceService = companyExperienceService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyExperienceResponse>> getAllCompanyExperiences() {
        return ResponseEntity.ok(companyExperienceService.getAllCompanyExperiences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyExperienceResponse> getCompanyExperienceById(@PathVariable Long id) {
        return ResponseEntity.ok(companyExperienceService.getCompanyExperienceById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyExperienceResponse> createCompanyExperience(@RequestBody CompanyExperienceRequest companyExperience) {
        return ResponseEntity.ok(companyExperienceService.createCompanyExperience(companyExperience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyExperienceResponse> updateCompanyExperience(@PathVariable Long id, @RequestBody CompanyExperienceRequest updateCompanyExperience) {
        return ResponseEntity.ok(companyExperienceService.updateCompanyExperience(id, updateCompanyExperience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyExperience(@PathVariable Long id) {
        companyExperienceService.deleteCompanyExperience(id);
        return ResponseEntity.noContent().build();
    }
}