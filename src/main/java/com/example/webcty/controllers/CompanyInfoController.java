package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyInfoRequest;
import com.example.webcty.dto.response.CompanyInfoResponse;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-info")
public class CompanyInfoController {
    private final CompanyInfoService companyInfoService;

    @Autowired
    public CompanyInfoController(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyInfoResponse>> getAllCompanyInfos() {
        return ResponseEntity.ok(companyInfoService.getAllCompanyInfos());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyInfoResponse> createCompanyInfo(@RequestBody CompanyInfoRequest companyInfo) {
        return ResponseEntity.ok(companyInfoService.createCompanyInfo(companyInfo));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyInfoResponse> updateCompanyInfo(@PathVariable Long id, @RequestBody CompanyInfoRequest updateCompanyInfo) {
        return ResponseEntity.ok(companyInfoService.updateCompanyInfo(id, updateCompanyInfo));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyInfo(@PathVariable Long id) {
        companyInfoService.deleteCompanyInfo(id);
        return ResponseEntity.noContent().build();
    }
}