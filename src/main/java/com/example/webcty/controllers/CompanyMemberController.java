package com.example.webcty.controllers;

import com.example.webcty.dto.request.CompanyMemberRequest;
import com.example.webcty.dto.response.CompanyMemberResponse;
import com.example.webcty.services.CompanyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-members")
public class CompanyMemberController {
    private final CompanyMemberService companyMemberService;

    @Autowired
    public CompanyMemberController (CompanyMemberService companyMemberService) {
        this.companyMemberService = companyMemberService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyMemberResponse>> getAllCompanyMembers() {
        return ResponseEntity.ok(companyMemberService.getAllCompanyMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyMemberResponse> getCompanyMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(companyMemberService.getCompanyMemberById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CompanyMemberResponse> createCompanyMember(@RequestBody CompanyMemberRequest request) {
        return ResponseEntity.ok(companyMemberService.createCompanyMember(request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CompanyMemberResponse> updateCompanyMember(@PathVariable Long id, @RequestBody CompanyMemberRequest request) {
        return ResponseEntity.ok(companyMemberService.updateCompanyMember(id, request));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyMember(@PathVariable Long id) {
        companyMemberService.deleteCompanyMember(id);
        return ResponseEntity.noContent().build();
    }
}