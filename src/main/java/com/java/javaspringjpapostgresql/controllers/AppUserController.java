package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.dtos.AppUserDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.UUID;

@Transactional
@RestController
@RequestMapping("app")
public class AppUserController {


    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private AppUserMapper appUserMap;


    @PostMapping("byId")
    public AppUserDTO appUserByIdWithPost (@RequestBody Map<String, Any> bodyWithUUID) throws Exception {

       UUID userId = UUID.fromString(bodyWithUUID.get("id").toString());

       AppUserEntity appUserEntity = appUserRepo.findById(userId).orElseThrow(() -> new Exception("User not found with id - " + userId));

       AppUserDTO appUserDTO = appUserMap.appUserEntityToAppUserDto(appUserEntity);

       return appUserDTO;

    }

}
