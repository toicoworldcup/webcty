package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyMemberRequest;
import com.example.webcty.dto.response.CompanyMemberResponse;
import com.example.webcty.entities.CompanyMember;
import com.example.webcty.repositories.CompanyMemberRepository;
import com.example.webcty.services.CompanyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyMemberServiceImpl implements CompanyMemberService {
    private final CompanyMemberRepository companyMemberRepository;

    @Autowired
    public CompanyMemberServiceImpl(CompanyMemberRepository companyMemberRepository) {
        this.companyMemberRepository = companyMemberRepository;
    }

    private CompanyMemberResponse convertToResponse(CompanyMember companyMember) {
        CompanyMemberResponse response = new CompanyMemberResponse();
        response.setId(companyMember.getId());
        response.setName(companyMember.getName());
        response.setPosition(companyMember.getPosition());
        response.setBio(companyMember.getBio());
        response.setEmail(companyMember.getEmail());
        response.setOrderIndex(companyMember.getOrderIndex());
        return response;
    }

    private CompanyMember convertToEntity(CompanyMemberRequest request) {
        CompanyMember companyMember = new CompanyMember();
        companyMember.setName(request.getName());
        companyMember.setPosition(request.getPosition());
        companyMember.setBio(request.getBio());
        companyMember.setEmail(request.getEmail());
        companyMember.setOrderIndex(request.getOrderIndex());
        return companyMember;
    }

    @Override
    public List<CompanyMemberResponse> getAllCompanyMembers() {
        return companyMemberRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public CompanyMemberResponse getCompanyMemberById(Long id) {
        return companyMemberRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("CompanyMember not found"));
    }

    @Override
    public CompanyMemberResponse createCompanyMember(CompanyMemberRequest request) {
        CompanyMember newCompanyMember = convertToEntity(request);
        CompanyMember savedCompanyMember = companyMemberRepository.save(newCompanyMember);
        return convertToResponse(savedCompanyMember);
    }

    @Override
    public CompanyMemberResponse updateCompanyMember(Long id, CompanyMemberRequest request) {
        CompanyMember existingCompanyMember = companyMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompanyMember not found"));

        existingCompanyMember.setName(request.getName());
        existingCompanyMember.setPosition(request.getPosition());
        existingCompanyMember.setBio(request.getBio());
        existingCompanyMember.setEmail(request.getEmail());
        existingCompanyMember.setOrderIndex(request.getOrderIndex());

        CompanyMember updatedCompanyMember = companyMemberRepository.save(existingCompanyMember);
        return convertToResponse(updatedCompanyMember);
    }

    @Override
    public void deleteCompanyMember(Long id) {
        if (!companyMemberRepository.existsById(id)) {
            throw new RuntimeException("CompanyMember not found");
        }
        companyMemberRepository.deleteById(id);
    }
}