package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyManagerRequest;
import com.example.webcty.dto.response.CompanyManagerResponse;
import com.example.webcty.services.CompanyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-manager")
public class CompanyManagerController {
    private final CompanyManagerService companyManagerService;

    @Autowired
    public CompanyManagerController(CompanyManagerService companyManagerService) {
        this.companyManagerService = companyManagerService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyManagerResponse>> getAllCompanyManager() {
        return ResponseEntity.ok(companyManagerService.getAllCompanyManager());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyManagerResponse> getCompanyManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(companyManagerService.getCompanyManagerById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyManagerResponse> createCompanyManager(@RequestBody CompanyManagerRequest CompanyManager) {
        return ResponseEntity.ok(companyManagerService.createCompanyManager(CompanyManager));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyManagerResponse> updateCompanyManager(@PathVariable Long id, @RequestBody CompanyManagerRequest updateCompanyManager) {
        return ResponseEntity.ok(companyManagerService.updateCompanyManager(id, updateCompanyManager));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyManager(@PathVariable Long id) {
        companyManagerService.deleteCompanyManager(id);
        return ResponseEntity.noContent().build();
    }
}