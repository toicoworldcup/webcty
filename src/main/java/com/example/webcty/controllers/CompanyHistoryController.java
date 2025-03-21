package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyHistory;
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
    public ResponseEntity<List<CompanyHistory>> getAllCompanyHistory() {
        return ResponseEntity.ok(companyHistoryService.getAllCompanyHistory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyHistory> getCompanyHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(companyHistoryService.getCompanyHistoryById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyHistory> createCompanyHistory(@RequestBody CompanyHistory companyHistory) {
        return ResponseEntity.ok(companyHistoryService.createCompanyHistory(companyHistory));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyHistory> updateCompanyHistory(@PathVariable Long id, @RequestBody CompanyHistory updateCompanyHistory) {
        return ResponseEntity.ok(companyHistoryService.updateCompanyHistory(id, updateCompanyHistory));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyHistory(@PathVariable Long id) {
        companyHistoryService.deleteCompanyHistory(id);
        return ResponseEntity.noContent().build();
    }
}