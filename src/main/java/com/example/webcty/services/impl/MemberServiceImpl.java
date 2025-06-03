package com.example.webcty.services.impl;

import com.example.webcty.dto.request.MemberRequest;
import com.example.webcty.dto.response.MemberResponse;
import com.example.webcty.entities.Member;
import com.example.webcty.mapper.MemberMapper;
import com.example.webcty.repositories.MemberRepository;
import com.example.webcty.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.memberMapper = new MemberMapper();
    }

    @Override
    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(memberMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponse getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        return member != null ? memberMapper.toResponseDTO(member) : null;
    }

    @Override
    public MemberResponse createMember(MemberRequest memberDTO) {
        Member member = memberMapper.toEntity(memberDTO);
        Member savedMember = memberRepository.save(member);
        return memberMapper.toResponseDTO(savedMember);
    }

    @Override
    public MemberResponse updateMember(Long id, MemberRequest updatedMemberDTO) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            member.setUsername(updatedMemberDTO.getUsername());
            member.setEmail(updatedMemberDTO.getEmail());
            member.setEmCode(updatedMemberDTO.getEmCode());
            Member updatedMember = memberRepository.save(member);
            return memberMapper.toResponseDTO(updatedMember);
        }
        return null;
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
