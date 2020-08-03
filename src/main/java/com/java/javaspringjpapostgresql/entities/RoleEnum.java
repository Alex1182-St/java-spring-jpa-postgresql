package com.java.javaspringjpapostgresql.entities;


import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

    USER,

    ADMIN;


    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
