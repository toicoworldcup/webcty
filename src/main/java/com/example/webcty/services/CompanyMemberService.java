package com.example.webcty.services;

import com.example.webcty.entities.CompanyMember;

import java.util.List;

public interface CompanyMemberService {
    List<CompanyMember> getAllCompanyMembers();

    CompanyMember getCompanyMemberById(Long id);

    CompanyMember createCompanyMember(CompanyMember companyMember);

    CompanyMember updateCompanyMember(Long id, CompanyMember updatedCompanyMember);

    void deleteCompanyMember(Long id);
}
