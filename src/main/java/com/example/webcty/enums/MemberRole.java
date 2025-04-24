package com.example.webcty.enums;

import org.springframework.security.core.GrantedAuthority;

public enum MemberRole implements GrantedAuthority {
    ADMIN,
    EDITOR;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}