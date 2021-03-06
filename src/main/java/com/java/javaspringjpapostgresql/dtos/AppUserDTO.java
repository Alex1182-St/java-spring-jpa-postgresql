package com.java.javaspringjpapostgresql.dtos;


import java.util.Collection;
import java.util.UUID;

public class AppUserDTO {

    private UUID id;

    private String appUserLogin;

    private String appUserPassword;

    private String email;

    private Collection<UUID> roles;

    private String appUserSurname;

    private String appUserName;

    private String phone;

    public AppUserDTO(UUID id, String appUserLogin, String appUserPassword, String email, Collection<UUID> roles, String appUserSurname, String appUserName, String phone) {
        this.id = id;
        this.appUserLogin = appUserLogin;
        this.appUserPassword = appUserPassword;
        this.email = email;
        this.roles = roles;
        this.appUserSurname = appUserSurname;
        this.appUserName = appUserName;
        this.phone = phone;
    }

    public AppUserDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAppUserLogin() {
        return appUserLogin;
    }

    public void setAppUserLogin(String appUserLogin) {
        this.appUserLogin = appUserLogin;
    }

    public String getAppUserPassword() {
        return appUserPassword;
    }

    public void setAppUserPassword(String appUserPassword) {
        this.appUserPassword = appUserPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<UUID> getRoles() {
        return roles;
    }

    public void setRoles(Collection<UUID> roles) {
        this.roles = roles;
    }

    public String getAppUserSurname() {
        return appUserSurname;
    }

    public void setAppUserSurname(String appUserSurname) {
        this.appUserSurname = appUserSurname;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
