package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyInfo;
import com.example.webcty.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-info")
public class CompanyInfoController {
    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping
    public ResponseEntity<List<CompanyInfo>> getAllCompanyInfo() {
        return ResponseEntity.ok(companyInfoService.getAllCompanyInfo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyInfo> getCompanyInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(companyInfoService.getCompanyInfoById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyInfo> createCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        return ResponseEntity.ok(companyInfoService.createCompanyInfo(companyInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyInfo> updateCompanyInfo(@PathVariable Long id, @RequestBody CompanyInfo updateCompanyInfo) {
        return ResponseEntity.ok(companyInfoService.updateCompanyInfo(id, updateCompanyInfo));    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyInfo(@PathVariable Long id) {
        companyInfoService.deleteCompanyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
