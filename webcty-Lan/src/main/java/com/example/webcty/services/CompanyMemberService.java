package com.example.webcty.services;

import com.example.webcty.dto.request.CompanyMemberRequest;
import com.example.webcty.dto.response.CompanyMemberResponse;

import java.util.List;

public interface CompanyMemberService {
    List<CompanyMemberResponse> getAllCompanyMembers();

    CompanyMemberResponse getCompanyMemberById(Long id);

    CompanyMemberResponse createCompanyMember(CompanyMemberRequest request);

    CompanyMemberResponse updateCompanyMember(Long id, CompanyMemberRequest request);

    void deleteCompanyMember(Long id);
}