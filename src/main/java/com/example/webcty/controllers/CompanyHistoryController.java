package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyHistoryRequest;
import com.example.webcty.dto.response.CompanyHistoryResponse;
import com.example.webcty.services.CompanyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-history")
public class CompanyHistoryController {
    private final CompanyHistoryService companyHistoryService;

    @Autowired
    public CompanyHistoryController (CompanyHistoryService companyHistoryService) {
        this.companyHistoryService = companyHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyHistoryResponse>> getAllCompanyHistory() {
        return ResponseEntity.ok(companyHistoryService.getAllCompanyHistory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyHistoryResponse> getCompanyHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(companyHistoryService.getCompanyHistoryById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyHistoryResponse> createCompanyHistory(@RequestBody CompanyHistoryRequest request) {
        return ResponseEntity.ok(companyHistoryService.createCompanyHistory(request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyHistoryResponse> updateCompanyHistory(@PathVariable Long id, @RequestBody CompanyHistoryRequest request) {
        return ResponseEntity.ok(companyHistoryService.updateCompanyHistory(id, request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyHistory(@PathVariable Long id) {
        companyHistoryService.deleteCompanyHistory(id);
        return ResponseEntity.noContent().build();
    }
}