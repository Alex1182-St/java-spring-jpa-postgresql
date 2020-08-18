package com.java.javaspringjpapostgresql.controllers;


import com.java.javaspringjpapostgresql.entities.RoleEntity;
import com.java.javaspringjpapostgresql.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@RestController
@RequestMapping("role")

public class RoleController {

    @Autowired
    private RoleRepository roleRepo;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("all")
    public Collection<RoleEntity> roleByName () {
        return roleRepo.findAll();
    }


}
