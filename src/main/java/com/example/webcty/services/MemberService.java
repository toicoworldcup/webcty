package com.example.webcty.services;

import com.example.webcty.dto.request.MemberRequest;
import com.example.webcty.dto.response.MemberResponse;
import com.example.webcty.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<MemberResponse> getAllMembers();

    MemberResponse getMemberById(Long id);

    MemberResponse createMember(MemberRequest member);

    MemberResponse updateMember(Long id, MemberRequest updatedMember);

    void deleteMember(Long id);

    Optional<Member> findByUsername(String username);
}
