package com.example.webcty.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyMemberRequest {
    private String name;
    private String position;
    private String bio;
    private String email;
    private Integer orderIndex;
}
