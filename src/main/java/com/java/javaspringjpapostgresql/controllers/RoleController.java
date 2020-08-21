package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.dtos.RoleDTO;
import com.java.javaspringjpapostgresql.dtos.RoleDTOMapper;
import com.java.javaspringjpapostgresql.entities.RoleEntity;
import com.java.javaspringjpapostgresql.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Transactional
@RestController
@RequestMapping("role")

public class RoleController {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private RoleDTOMapper roleDTOMapp;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("all")
    public Collection<RoleDTO> allRoles () {

        Collection<RoleEntity> allRoles = roleRepo.findAll();

        Collection<RoleDTO> allDTORoles = new ArrayList<>();


        for (RoleEntity roleEntity : allRoles) {
            allDTORoles.add(roleDTOMapp.toRoleDTO(roleEntity));
        }
      return allDTORoles;

    }


}
