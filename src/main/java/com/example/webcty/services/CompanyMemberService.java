package com.example.webcty.services;

import com.example.webcty.entities.CompanyMember;
import com.example.webcty.repositories.CompanyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMemberService {
    @Autowired
    private CompanyMemberRepository companyMemberRepository;

    public List<CompanyMember> getAllCompanyMembers() {
        return companyMemberRepository.findAll();
    }

    public CompanyMember getCompanyMemberById(Long id) {
        return companyMemberRepository.findById(id).orElse(null);
    }

    public CompanyMember createCompanyMember(CompanyMember companyMember) {
        return companyMemberRepository.save(companyMember);
    }

    public CompanyMember updateCompanyMember(Long id, CompanyMember updatedCompanyMember) {
        CompanyMember companyMember = getCompanyMemberById(id);
        companyMember.setName(updatedCompanyMember.getName());
        companyMember.setPosition(updatedCompanyMember.getPosition());
        companyMember.setBio(updatedCompanyMember.getBio());
        companyMember.setEmail(updatedCompanyMember.getEmail());
        companyMember.setOrderIndex(updatedCompanyMember.getOrderIndex());
        return companyMemberRepository.save(companyMember);
    }

    public void deleteCompanyMember(Long id) {
        companyMemberRepository.deleteById(id);
    }
}