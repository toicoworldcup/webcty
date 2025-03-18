package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyDetail;
import com.example.webcty.services.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-details")
public class CompanyDetailController {
    @Autowired
    private CompanyDetailService companyDetailService;

    @GetMapping
    public ResponseEntity<List<CompanyDetail>> getAllCompanyDetails() {
        return ResponseEntity.ok(companyDetailService.getAllCompanyDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetail> getCompanyDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(companyDetailService.getCompanyDetailById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyDetail> createCompanyDetail(@RequestBody CompanyDetail companyDetail) {
        return ResponseEntity.ok(companyDetailService.createCompanyDetail(companyDetail));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDetail> updateCompanyDetail(@PathVariable Long id, @RequestBody CompanyDetail updateCompanyDetail) {
        return ResponseEntity.ok(companyDetailService.updateCompanyDetail(id, updateCompanyDetail));    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyDetail(@PathVariable Long id) {
        companyDetailService.deleteCompanyDetail(id);
        return ResponseEntity.noContent().build();
    }
}
