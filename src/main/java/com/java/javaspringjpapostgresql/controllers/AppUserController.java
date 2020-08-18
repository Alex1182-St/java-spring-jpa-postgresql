package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.dtos.AppUserDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserDTOMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private AppUserDTOMapper appUserMap;


    @PostMapping("byId")
    public AppUserDTO appUserByIdWithPost (@RequestBody Map<String, Object> bodyWithUUID) throws Exception {

       UUID userId = UUID.fromString(bodyWithUUID.get("id").toString());
       AppUserEntity appUserEntity = appUserRepo.findById(userId).orElseThrow(() -> new Exception("User not found with id - " + userId));
       return appUserMap.toAppUserDto(appUserEntity);
    }

    @PostMapping("byMail")
    public AppUserDTO appUserByEmail (@RequestBody Map<String, Object> email) throws  Exception {

        String userEmail = email.get("appUserEmail").toString();
        AppUserEntity appUserEntity = appUserRepo.findByEmail(userEmail).orElseThrow(() -> new Exception("User not found with id - " + email));
        return appUserMap.toAppUserDto(appUserEntity);
    }

}
