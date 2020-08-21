package com.java.javaspringjpapostgresql.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, unique = true, nullable = false)
    private RoleEnum name;

    @ManyToMany(
            mappedBy = "roles",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<AppUserEntity> appUsers = new HashSet<>();


    public RoleEntity() {
    }

    public RoleEntity(UUID id, RoleEnum name, Set<AppUserEntity> appUsers) {
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


