package com.example.webcty.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMemberResponse {
    private Long id;
    private String name;
    private String position;
    private String bio;
    private String email;
    private Integer orderIndex;
}
