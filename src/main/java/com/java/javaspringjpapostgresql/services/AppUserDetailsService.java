package com.java.javaspringjpapostgresql.services;


import com.java.javaspringjpapostgresql.dtos.AppUserDetailsDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserDetailsDTOMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private AppUserDetailsDTOMapper appUserDetailsDtoMapp;


    @Override
    public AppUserDetailsDTO loadUserByUsername(String login) throws UsernameNotFoundException {

        AppUserEntity appUserEntity = appUserRepo.findByAppUserLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));

        return appUserDetailsDtoMapp.toAppUserDetailsDTO(appUserEntity);
    }
}
