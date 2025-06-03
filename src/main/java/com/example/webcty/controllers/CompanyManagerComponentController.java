package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;
import com.example.webcty.services.CompanyManagerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-manager-component")
public class CompanyManagerComponentController {
    private final CompanyManagerComponentService companyManagerComponentService;

    @Autowired
    public CompanyManagerComponentController(CompanyManagerComponentService companyManagerComponentService) {
        this.companyManagerComponentService = companyManagerComponentService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyManagerComponentResponse>> getAllCompanyManagerComponent() {
        return ResponseEntity.ok(companyManagerComponentService.getAllCompanyManagerComponent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyManagerComponentResponse> getCompanyManagerComponentById(@PathVariable Long id) {
        return ResponseEntity.ok(companyManagerComponentService.getCompanyManagerComponentById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyManagerComponentResponse> createCompanyManagerComponent(@RequestBody CompanyManagerComponentRequest companyManager) {
        return ResponseEntity.ok(companyManagerComponentService.createCompanyManagerComponent(companyManager));
    }

    @PutMapping("/reorder")
    public ResponseEntity<Void> reorderCompanyManagerComponent(@RequestBody List<ReorderRequest> reorderList) {
        companyManagerComponentService.reorderCompanyManagerComponent(reorderList);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyManagerComponentResponse> updateCompanyManagerComponent(@PathVariable Long id, @RequestBody CompanyManagerComponentRequest updateCompanyManager) {
        return ResponseEntity.ok(companyManagerComponentService.updateCompanyManagerComponent(id, updateCompanyManager));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyManagerComponent(@PathVariable Long id) {
        companyManagerComponentService.deleteCompanyManagerComponent(id);
        return ResponseEntity.noContent().build();
    }
}