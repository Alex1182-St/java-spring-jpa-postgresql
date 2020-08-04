package com.java.javaspringjpapostgresql.services;


import com.java.javaspringjpapostgresql.dtos.AppUserDetailsDTO;
import com.java.javaspringjpapostgresql.dtos.AppUserMapper;
import com.java.javaspringjpapostgresql.entities.AppUserEntity;
import com.java.javaspringjpapostgresql.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepo;

    @Override
    public AppUserDetailsDTO loadUserByUsername(String login) throws UsernameNotFoundException {

        AppUserEntity appUserEntity = appUserRepo.findByAppUserLogin(login).orElseThrow();

        AppUserDetailsDTO appUserDetailsDTO = AppUserMapper.INSTANCE.appUserEntityToAppUserDetailsDTO(appUserEntity);

        return appUserDetailsDTO;
    }
}
