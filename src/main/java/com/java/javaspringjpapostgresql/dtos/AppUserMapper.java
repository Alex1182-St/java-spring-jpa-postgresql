package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserMapper {

    AppUserDTO appUserEntityToAppUserDto(AppUserEntity appUserEntity);

    Set<RoleDTO> rolesToDTO(Set<RoleDTO> roleEntities);

}

