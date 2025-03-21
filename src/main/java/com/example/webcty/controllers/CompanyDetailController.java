package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyDetail;
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

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @GetMapping
    public ResponseEntity<List<CompanyDetail>> getAllCompanyDetails() {
        return ResponseEntity.ok(companyDetailService.getAllCompanyDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetail> getCompanyDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(companyDetailService.getCompanyDetailById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyDetail> createCompanyDetail(@RequestBody CompanyDetail companyDetail) {
        return ResponseEntity.ok(companyDetailService.createCompanyDetail(companyDetail));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDetail> updateCompanyDetail(@PathVariable Long id, @RequestBody CompanyDetail updateCompanyDetail) {
        return ResponseEntity.ok(companyDetailService.updateCompanyDetail(id, updateCompanyDetail));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyDetail(@PathVariable Long id) {
        companyDetailService.deleteCompanyDetail(id);
        return ResponseEntity.noContent().build();
    }
}