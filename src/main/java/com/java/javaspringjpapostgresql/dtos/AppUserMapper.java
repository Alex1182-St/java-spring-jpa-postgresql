package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);


    AppUserDTO appUserEntityToAppUserDto(AppUserEntity appUserEntity);


    @ValueMapping(source = "AppUserEntity.appUserLogin", target = "username")
    @ValueMapping(source = "AppUserEntity.appUserPassword", target = "password")
    @ValueMapping(source = "AppUserEntity.roles", target = "authorities")

    AppUserDetailsDTO appUserEntityToAppUserDetailsDTO(AppUserEntity appUserEntity);
}
