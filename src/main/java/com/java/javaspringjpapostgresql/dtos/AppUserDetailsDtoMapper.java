package com.java.javaspringjpapostgresql.dtos;


import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
    public abstract class AppUserDetailsDtoMapper {

        @Mappings({
                @Mapping(target = "username", source = "appUserLogin"),
                @Mapping(target = "password", source = "appUserPassword"),
                @Mapping(target = "authorities", expression = "java( mapAuthorities(user.getRoles()) )")
        })
        public abstract AppUserDetailsDTO toAppUserDetailsDTO(AppUserEntity user);

        protected Collection<GrantedAuthority> mapAuthorities(Set<RoleEntity> roles) {

            Collection<GrantedAuthority> authorities = new HashSet<>();
            authorities.add((GrantedAuthority) roles);
            return authorities;

        }
    }

/*

@Mapper(componentModel = "spring")
public abstract class AppUserDetailsDtoMapper {

    @Mappings({
            @Mapping(target = "username", source = "appUserLogin"),
            @Mapping(target = "password", source = "appUserPassword"),
            @Mapping(target = "authorities", expression = "java( mapAuthorities(user.getRoles()) )")
    })
    public abstract AppUserDetailsDTO toAppUserDetailsDTO(AppUserEntity user);

    protected Collection<GrantedAuthority> mapAuthorities(Set<RoleEntity> roles) {
        // Map the authorities here
    }
}
 */
