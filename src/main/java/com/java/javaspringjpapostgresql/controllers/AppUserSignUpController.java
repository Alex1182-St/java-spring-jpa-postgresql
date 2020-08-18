package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.dtos.AppUserCreateInput;
import com.java.javaspringjpapostgresql.dtos.AppUserDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserDTOMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.entities.RoleEntity;
import com.java.javaspringjpapostgresql.entities.RoleEnum;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import com.java.javaspringjpapostgresql.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@RestController
@RequestMapping("app")
public class AppUserSignUpController {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppUserDTOMapper appUserMap;

    @PostMapping("sign_up")
    public AppUserEntity appUserCreate(@RequestBody AppUserCreateInput newAppUser) {

        Set<RoleEntity> role = new HashSet<>();

        role.add(roleRepo.findByName(RoleEnum.USER));

        AppUserEntity appUser = new AppUserEntity();

        appUser.setAppUserLogin(newAppUser.getAppUserLogin());
        appUser.setAppUserPassword(passwordEncoder.encode(newAppUser.getAppUserPassword()));
        appUser.setEmail(newAppUser.getEmail());
        appUser.setAppUserSurname(newAppUser.getAppUserSurname());
        appUser.setAppUserName(newAppUser.getAppUserName());
        appUser.setPhone(newAppUser.getPhone());
        appUser.setSkype(newAppUser.getSkype());
        appUser.setUserAge(newAppUser.getAge());
        appUser.setRoles(role);


        return appUser;
    }




}

/*
public AppUserDTO appUserCreate(@RequestBody AppUserCreateInput newAppUser) {

        Set<RoleEntity> role = new HashSet<>();

        role.add(roleRepo.findByName(RoleEnum.USER));

        AppUserEntity appUser = new AppUserEntity();

        appUser.setAppUserLogin(newAppUser.getAppUserLogin());
        appUser.setAppUserPassword(passwordEncoder.encode(newAppUser.getAppUserPassword()));
        appUser.setEmail(newAppUser.getEmail());
        appUser.setAppUserSurname(newAppUser.getAppUserSurname());
        appUser.setAppUserName(newAppUser.getAppUserName());
        appUser.setPhone(newAppUser.getPhone());
        appUser.setSkype(newAppUser.getSkype());
        appUser.setUserAge(newAppUser.getAge());
        appUser.setRoles(role);


        return appUserMap.toAppUserDto(appUserRepo.save(appUser));
    }

  */