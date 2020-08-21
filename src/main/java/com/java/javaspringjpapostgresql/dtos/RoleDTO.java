package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.RoleEnum;

import java.util.Collection;

import java.util.UUID;

public class RoleDTO {

    private UUID id;

    private RoleEnum name;

    private Collection<UUID> appUsers;

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

    public Collection<UUID> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Collection<UUID> appUsers) {
        this.appUsers = appUsers;
    }

    public RoleDTO() {
    }

    public RoleDTO(UUID id, RoleEnum name, Collection<UUID> appUsers) {
        this.id = id;
        this.name = name;
        this.appUsers = appUsers;
    }
}
