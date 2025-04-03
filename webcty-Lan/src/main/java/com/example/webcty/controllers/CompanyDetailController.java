package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyDetailRequest;
import com.example.webcty.dto.response.CompanyDetailResponse;
import com.example.webcty.services.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-details")
public class CompanyDetailController {
    private final CompanyDetailService companyDetailService;

    @Autowired
    public CompanyDetailController(CompanyDetailService companyDetailService) {
        this.companyDetailService = companyDetailService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDetailResponse>> getAllCompanyDetails() {
        return ResponseEntity.ok(companyDetailService.getAllCompanyDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailResponse> getCompanyDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(companyDetailService.getCompanyDetailById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyDetailResponse> createCompanyDetail(@RequestBody CompanyDetailRequest request) {
        return ResponseEntity.ok(companyDetailService.createCompanyDetail(request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDetailResponse> updateCompanyDetail(@PathVariable Long id, @RequestBody CompanyDetailRequest request) {
        return ResponseEntity.ok(companyDetailService.updateCompanyDetail(id, request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyDetail(@PathVariable Long id) {
        companyDetailService.deleteCompanyDetail(id);
        return ResponseEntity.noContent().build();
    }
}