package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;

import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppUserDTOMapper {

    AppUserDTO appUserEntityToAppUserDto(AppUserEntity appUserEntity);

    Set<RoleDTO> rolesToDTO(Set<RoleEntity> roleEntities);

}

