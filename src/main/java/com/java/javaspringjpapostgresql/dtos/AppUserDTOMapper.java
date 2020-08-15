package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;

import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;


@Mapper(componentModel = "spring")
public abstract class AppUserDTOMapper {

    @Mapping(target = "roles", expression = "java( mapRoles(user.getRoles()) )")
    public abstract AppUserDTO toAppUserDto(AppUserEntity user);

    protected Collection<UUID> mapRoles(Set<RoleEntity> roles) {

        ArrayList<RoleEntity> roleList = new ArrayList<>();

        roleList.addAll(roles);

        Collection<UUID> rolesIDs = new ArrayList<>();

        for (RoleEntity roleEntity : roleList) {
            rolesIDs.add(roleEntity.getId());
        }

        return rolesIDs;
    }
}

