package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.entities.RoleEnum;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

public class RoleDTO {

    private UUID id;

    private RoleEnum name;

    private Set<AppUserEntity> appUsers;

    public RoleDTO() {
    }

    public RoleDTO(UUID id, RoleEnum name, Set<AppUserEntity> appUsers) {
        this.id = id;
        this.name = name;
        this.appUsers = appUsers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    public Set<AppUserEntity> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Set<AppUserEntity> appUsers) {
        this.appUsers = appUsers;
    }
}
