package com.example.webcty.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest  {
    private String username;
    private String password;
}
