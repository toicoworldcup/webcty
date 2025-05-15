package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanySupportRequest;
import com.example.webcty.dto.response.CompanySupportResponse;
import com.example.webcty.services.CompanySupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-supports")
public class CompanySupportController {
    private final CompanySupportService companySupportService;

    @Autowired
    public CompanySupportController(CompanySupportService companySupportService) {
        this.companySupportService = companySupportService;
    }

    @GetMapping
    public ResponseEntity<List<CompanySupportResponse>> getAllCompanySupports() {
        return ResponseEntity.ok(companySupportService.getAllCompanySupports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanySupportResponse> getCompanySupportById(@PathVariable Long id) {
        return ResponseEntity.ok(companySupportService.getCompanySupportById(id));
    }

    @PostMapping
    public ResponseEntity<CompanySupportResponse> createCompanySupport(@RequestBody CompanySupportRequest companySupport) {
        return ResponseEntity.ok(companySupportService.createCompanySupport(companySupport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanySupportResponse> updateCompanySupport(@PathVariable Long id, @RequestBody CompanySupportRequest updateCompanySupport) {
        return ResponseEntity.ok(companySupportService.updateCompanySupport(id, updateCompanySupport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanySupport(@PathVariable Long id) {
        companySupportService.deleteCompanySupport(id);
        return ResponseEntity.noContent().build();
    }
}