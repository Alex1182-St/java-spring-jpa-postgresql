package com.java.javaspringjpapostgresql.dtos;


import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public abstract class AppUserDetailsDTOMapper {

        @Mappings({
                @Mapping(target = "username", source = "appUserLogin"),
                @Mapping(target = "password", source = "appUserPassword"),
                @Mapping(target = "authorities", expression = "java( mapAuthorities(user.getRoles()) )")
        })
        public abstract AppUserDetailsDTO toAppUserDetailsDTO(AppUserEntity user);

        protected Collection<GrantedAuthority> mapAuthorities(Set<RoleEntity> roles) {


            ArrayList<RoleEntity> roleList = new ArrayList<>();

            roleList.addAll(roles);

            Collection<GrantedAuthority> authorities = new ArrayList<>();

            for (RoleEntity roleEntity : roleList) {
                authorities.add(roleEntity.getName());
                            }

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


/*

List listSource = new ArrayList();

listSource.add("123");

listSource.add("456");

List listDest   = new ArrayList();

listDest.addAll(listSource);
Этот пример добавляет все элементы из listSource в listDest.
             */


/*


public static void main(String[] args) {
    List<Car> cars = Arrays.asList(
            new Car("AA1111BX", 2007),
            new Car("AM1111BE", 2009),
            new Car("AK5555IT", 2010),
            new Car("AI5601CC", 2015),
            new Car("AI3838PP", 2017));

    cars.stream()
            .map(Car::getNumber) // преобразовываем Stream машин в Stream номеров
            .forEach(System.out::println);
}
 */
