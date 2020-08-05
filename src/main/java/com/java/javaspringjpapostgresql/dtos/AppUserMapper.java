package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "appUserLogin",target = "appUserLogin" )
    @Mapping(source = "appUserPassword",target = "appUserPassword")
    @Mapping(source = "email",target = "email" )
    @Mapping(source = "roles",target = "roles")
    @Mapping(source = "appUserSurname",target = "appUserSurname")
    @Mapping(source = "appUserName",target = "appUserName")
    @Mapping(source = "phone",target = "phone")
    AppUserDTO appUserEntityToAppUserDto(AppUserEntity appUserEntity);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "appUserLogin", target = "username")
    @Mapping(source = "appUserPassword", target = "password")
    @Mapping(source = "roles", target = "authorities")
    @Mapping(source = "isEnabled", target = "isEnabled")
    @Mapping(source = "isAccountNonLocked", target = "isAccountNonLocked")
    @Mapping(source = "isAccountNonExpired", target = "isAccountNonExpired")
    @Mapping(source = "isCredentialsNonExpired", target = "isCredentialsNonExpired")
    AppUserDetailsDTO appUserEntityToAppUserDetailsDTO(AppUserEntity appUserEntity);

}
