package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyServiceRequest;
import com.example.webcty.dto.response.CompanyServiceResponse;
import com.example.webcty.services.CompanyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-services")
public class CompanyServiceController {
    private final CompanyServiceService companyServiceService;

    @Autowired
    public CompanyServiceController(CompanyServiceService companyServiceService) {
        this.companyServiceService = companyServiceService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyServiceResponse>> getAllCompanyServices() {
        return ResponseEntity.ok(companyServiceService.getAllCompanyServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyServiceResponse> getCompanyServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(companyServiceService.getCompanyServiceById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyServiceResponse> createCompanyService(@RequestBody CompanyServiceRequest companyService) {
        return ResponseEntity.ok(companyServiceService.createCompanyService(companyService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyServiceResponse> updateCompanyService(@PathVariable Long id, @RequestBody CompanyServiceRequest updatedCompanyService) {
        return ResponseEntity.ok(companyServiceService.updateCompanyService(id, updatedCompanyService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyService(@PathVariable Long id) {
        companyServiceService.deleteCompanyService(id);
        return ResponseEntity.noContent().build();
    }
}