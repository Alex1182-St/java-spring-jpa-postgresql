package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserDetailsMapper {

    @Mapping(source = "appUserLogin", target = "username")
    @Mapping(source = "appUserPassword", target = "password")
    @Mapping(source = "roles", target = "authorities")
    AppUserDetailsDTO appUserEntityToAppUserDetailsDto(AppUserEntity appUserEntity);
    Set<RoleDTO> rolesToDTO(Set<RoleDTO> roleEntities);


}

