package com.example.webcty.dto.response;

import com.example.webcty.enums.MemberRole;
import lombok.Data;

@Data
public class MemberResponse {
    private Long id;
    private String username;
    private String email;
    private String emCode;
    private MemberRole role;
}
