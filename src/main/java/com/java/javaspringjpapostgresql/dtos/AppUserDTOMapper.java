package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.AppUserEntity;

import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface AppUserDTOMapper {

    AppUserDTO toAppUserDto(AppUserEntity appUserEntity);

    Set<RoleDTO> rolesToDTO(Set<RoleEntity> roleEntities);

}


/*

public abstract class AppUserDetailsDTOMapper {

        @Mappings({
                @Mapping(target = "username", source = "appUserLogin"),
                @Mapping(target = "password", source = "appUserPassword"),
                @Mapping(target = "authorities", expression = "java( mapAuthorities(user.getRoles()) )")
        })
        public abstract AppUserDetailsDTO toAppUserDetailsDTO(AppUserEntity user);

        protected Collection<GrantedAuthority> mapAuthorities(Set<RoleEntity> roles) {
 */

