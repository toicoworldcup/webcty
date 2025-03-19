package com.example.webcty.services.impl;

import com.example.webcty.entities.CompanyMember;
import com.example.webcty.repositories.CompanyMemberRepository;
import com.example.webcty.services.CompanyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMemberServiceImpl implements CompanyMemberService {
    @Autowired
    private CompanyMemberRepository companyMemberRepository;

    @Override
    public List<CompanyMember> getAllCompanyMembers() {
        return companyMemberRepository.findAll();
    }

    @Override
    public CompanyMember getCompanyMemberById(Long id) {
        return companyMemberRepository.findById(id).orElse(null);
    }

    @Override
    public CompanyMember createCompanyMember(CompanyMember companyMember) {
        return companyMemberRepository.save(companyMember);
    }

    @Override
    public CompanyMember updateCompanyMember(Long id, CompanyMember updatedCompanyMember) {
        CompanyMember companyMember = getCompanyMemberById(id);
        companyMember.setName(updatedCompanyMember.getName());
        companyMember.setPosition(updatedCompanyMember.getPosition());
        companyMember.setBio(updatedCompanyMember.getBio());
        companyMember.setEmail(updatedCompanyMember.getEmail());
        companyMember.setOrderIndex(updatedCompanyMember.getOrderIndex());
        return companyMemberRepository.save(companyMember);
    }

    @Override
    public void deleteCompanyMember(Long id) {
        companyMemberRepository.deleteById(id);
    }
}