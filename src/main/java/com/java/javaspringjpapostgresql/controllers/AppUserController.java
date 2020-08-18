package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.dtos.AppUserDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserDTOMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import org.hibernate.mapping.Any;
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
    public AppUserDTO appUserByIdWithPost (@RequestBody Map<String, Any> bodyWithUUID) throws Exception {

       UUID userId = UUID.fromString(bodyWithUUID.get("id").toString());
       AppUserEntity appUserEntity = appUserRepo.findById(userId).orElseThrow(() -> new Exception("User not found with id - " + userId));
       return appUserMap.toAppUserDto(appUserEntity);
    }

    @GetMapping("byMail")
    public AppUserEntity appUserByEmail (@PathVariable String email) throws  Exception {
        return appUserRepo.findByEmail(email).orElseThrow(() -> new Exception("User not found with id - " + email));
    }

}

/*
Десь є помилки
 "timestamp": "2020-08-18T07:29:29.615+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/app/byId"
}

"timestamp": "2020-08-18T07:28:26.928+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/app/byMail"

 */



    /*
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("byId2")
    public AppUserEntity appUserByIdReturnEntity (@PathVariable UUID id) throws Exception {
        return appUserRepo.findById(id).orElseThrow(() -> new Exception("User not found with id - " + id));
    }

    @GetMapping("byMail")
    public AppUserDTO appUserByEmail (@PathVariable String email) throws  Exception {
        AppUserEntity appUserEntity = appUserRepo.findByEmail(email).orElseThrow(() -> new Exception("User not found with id - " + email));
        return appUserMap.toAppUserDto(appUserEntity);
    }

    */
