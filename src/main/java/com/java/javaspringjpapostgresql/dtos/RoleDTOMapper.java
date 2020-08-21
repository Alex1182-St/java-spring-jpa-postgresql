package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;


@Mapper(componentModel = "spring")
public abstract class RoleDTOMapper {

    @Mapping(target = "appUsers", expression = "java( mapAppUsers(role.getAppUsers()) )")
    public abstract RoleDTO toRoleDTO (RoleEntity role);

    protected Collection<UUID> mapAppUsers(Set<AppUserEntity> appUserEntities) {

        ArrayList<AppUserEntity> appUserEntitiesList = new ArrayList<>();

        appUserEntitiesList.addAll(appUserEntities);

        Collection<UUID> appUsersIDs = new ArrayList<>();

        for (AppUserEntity appUserEntity : appUserEntitiesList) {
            appUsersIDs.add(appUserEntity.getId());
        }
        return  appUsersIDs;

    }

}