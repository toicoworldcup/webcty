package com.example.webcty.controllers;

import com.example.webcty.entities.CompanyMember;
import com.example.webcty.services.CompanyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CompanyMember>> getAllCompanyMembers() {
        return ResponseEntity.ok(companyMemberService.getAllCompanyMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyMember> getCompanyMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(companyMemberService.getCompanyMemberById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyMember> createCompanyMember(@RequestBody CompanyMember companyMember) {
        return ResponseEntity.ok(companyMemberService.createCompanyMember(companyMember));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyMember> updateCompanyMember(@PathVariable Long id, @RequestBody CompanyMember updateCompanyMember) {
        return ResponseEntity.ok(companyMemberService.updateCompanyMember(id, updateCompanyMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyMember(@PathVariable Long id) {
        companyMemberService.deleteCompanyMember(id);
        return ResponseEntity.noContent().build();
    }
}