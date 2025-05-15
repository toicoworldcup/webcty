package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyPartnerRequest;
import com.example.webcty.dto.response.CompanyPartnerResponse;
import com.example.webcty.dto.response.CompanySupportResponse;
import com.example.webcty.services.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-partners")
public class CompanyPartnerController {
    private final CompanyPartnerService companyPartnerService;

    @Autowired
    public CompanyPartnerController(CompanyPartnerService companyPartnerService) {
        this.companyPartnerService = companyPartnerService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyPartnerResponse>> getAllCompanyPartners() {
        return ResponseEntity.ok(companyPartnerService.getAllCompanyPartners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyPartnerResponse> getCompanyPartnerById(@PathVariable Long id) {
        return ResponseEntity.ok(companyPartnerService.getCompanyPartnerById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyPartnerResponse> createCompanyPartner(@RequestBody CompanyPartnerRequest companyPartner) {
        return ResponseEntity.ok(companyPartnerService.createCompanyPartner(companyPartner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyPartnerResponse> updateCompanyPartner(@PathVariable Long id, @RequestBody CompanyPartnerRequest updateCompanyPartner) {
        return ResponseEntity.ok(companyPartnerService.updateCompanyPartner(id, updateCompanyPartner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyPartner(@PathVariable Long id) {
        companyPartnerService.deleteCompanyPartner(id);
        return ResponseEntity.noContent().build();
    }
}