package com.example.webcty.services;

import com.example.webcty.entities.Member;
import com.example.webcty.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member member = getMemberById(id);
        member.setName(updatedMember.getName());
        member.setPosition(updatedMember.getPosition());
        member.setBio(updatedMember.getBio());
        member.setEmail(updatedMember.getEmail());
        member.setOrderIndex(updatedMember.getOrderIndex());
        member.setModifiedBy(updatedMember.getModifiedBy());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
