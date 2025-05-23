package com.example.webcty.mapper;

import com.example.webcty.dto.request.MemberRequest;
import com.example.webcty.dto.response.MemberResponse;
import com.example.webcty.entities.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member toEntity(MemberRequest dto) {
        Member member = new Member();
        member.setUsername(dto.getUsername());
        member.setEmail(dto.getEmail());
        member.setEmCode(dto.getEmCode());
        member.setPassword(dto.getPassword());
        member.setRole(dto.getRole());
        member.setCreatedBy("admin"); // Mặc định created_by là admin
        return member;
    }

    public MemberResponse toResponseDTO(Member entity) {
        MemberResponse dto = new MemberResponse();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setEmCode(entity.getEmCode());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }
}