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

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyDetailResponse> createCompanyDetail(@RequestBody CompanyDetailRequest companyDetail) {
        return ResponseEntity.ok(companyDetailService.createCompanyDetail(companyDetail));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDetailResponse> updateCompanyDetail(@PathVariable Long id, @RequestBody CompanyDetailRequest updateCompanyDetail) {
        return ResponseEntity.ok(companyDetailService.updateCompanyDetail(id, updateCompanyDetail));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyDetail(@PathVariable Long id) {
        companyDetailService.deleteCompanyDetail(id);
        return ResponseEntity.noContent().build();
    }
}