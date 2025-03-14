package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-info")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping
    public List<CompanyInfo> getAllCompanyInfo() {
        return companyInfoService.getAllCompanyInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyInfo> getCompanyInfoById(@PathVariable Long id) {
        return companyInfoService.getCompanyInfoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CompanyInfo> createCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        CompanyInfo savedInfo = companyInfoService.saveCompanyInfo(companyInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyInfo> updateCompanyInfo(@PathVariable Long id, @RequestBody CompanyInfo companyInfo) {
        if (!companyInfoService.getCompanyInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(companyInfoService.saveCompanyInfo(companyInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyInfo(@PathVariable Long id) {
        if (!companyInfoService.getCompanyInfoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        companyInfoService.deleteCompanyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
