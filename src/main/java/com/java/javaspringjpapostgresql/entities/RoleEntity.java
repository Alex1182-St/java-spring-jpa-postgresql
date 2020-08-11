package com.java.javaspringjpapostgresql.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleEnum name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "roles"
    )
    private Set<AppUserEntity> appUsers;

    public RoleEntity(UUID id, RoleEnum name, Set<AppUserEntity> appUsers) {
        this.id = id;
        this.name = name;
        this.appUsers = appUsers;
    }

    public RoleEntity() {
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


